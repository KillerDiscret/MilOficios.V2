package pe.edu.upc.demo.controllers;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.demo.entities.Usuario;
import pe.edu.upc.demo.serviceinterface.IUsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private IUsuarioService usuaService;
	
	@GetMapping("/nuevo")
	public String newUsuario(Model model) {

		model.addAttribute("u", new Usuario());

		return "usuario/frmRegister";
	}
	
	@PostMapping("/guardar")
	public String saveUsuario(@Valid Usuario us, BindingResult binRes, Model model) {

		if (binRes.hasErrors()) {

			model.addAttribute("error", "Ocurrió un error!");
			return "usuario/frmRegister";

		} else {

			usuaService.insert(us);
			model.addAttribute("mensaje", "Se guardó correctamente!");
			
			return "redirect:/usuario/listar";
		}
	}
	
	@GetMapping("/listar")
	public String listUsuario(Model model) {

		try {

			model.addAttribute("listaUsuarios", usuaService.list());

		} catch (Exception e) {

			model.addAttribute("error", e.getMessage());

		}

		return "usuario/frmList";
	}
	
	@RequestMapping("/eliminar")
	public String deleteUsuario(Map<String, Object> model, @RequestParam(value = "id") Integer id) {

		try {
			if (id != null && id > 0) {

				usuaService.delete(id);
				model.put("listaUsuarios", usuaService.list());

			}

		} catch (Exception e) {

			model.put("error", e.getMessage());
		}

		return "redirect:/usuario/listar";
	}
	
	@RequestMapping("irmodificar/{id}")
	public String goUpdateUsuario(@PathVariable int id, Model model) {

		Optional<Usuario> objUsua = usuaService.listId(id);

		model.addAttribute("usa", objUsua.get());

		return "usuario/frmUpdate";
	}
	
	
	@PostMapping("/modificar")
	public String updateUsuario(Usuario us) {

		usuaService.update(us);
		
		// el redirect:/ es para llamar a funciones dentro del Controller
		return "redirect:/usuario/listar";

	}
	

}
