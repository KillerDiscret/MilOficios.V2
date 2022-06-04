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

import pe.edu.upc.demo.entities.Rol;
import pe.edu.upc.demo.entities.Usuario;
import pe.edu.upc.demo.entities.UsuarioRol;
import pe.edu.upc.demo.serviceinterface.IRolService;
import pe.edu.upc.demo.serviceinterface.IUsuarioRolService;
import pe.edu.upc.demo.serviceinterface.IUsuarioService;

@Controller
@RequestMapping("/usuariorol")
public class UsuarioRolController {

	@Autowired //Se vincula los archivos de tipo service en el controller ya que es la conexion entre backend y frontend
	private IRolService roleService;
	
	@Autowired
	private IUsuarioService usuaService;
	
	@Autowired
	private IUsuarioRolService usurService;
	
	
	@GetMapping("/nuevo")
	public String newUsuarioRol(Model model) {
	
		model.addAttribute("r", new Rol());
		
		model.addAttribute("u", new Usuario());
		
		model.addAttribute("s", new UsuarioRol());
		
		model.addAttribute("listaRoles", roleService.list());
		
		model.addAttribute("listaUsuarios", usuaService.list());

		return "usuariorol/frmRegister";
	}
	
	@PostMapping("/guardar")
	public String saveUsuarioRol(@Valid UsuarioRol ur, BindingResult binRes, Model model) {

		if (binRes.hasErrors()) {

			model.addAttribute("error", "Ocurrió un error!");
			return "usuariorol/frmRegister";

		} else {

			usurService.insert(ur);
			model.addAttribute("mensaje", "Se guardó correctamente!");
			
			return "redirect:/usuariorol/listar";
		}
	}
	
	@GetMapping("/listar")
	public String listUsuarioRol(Model model) {

		try {

			model.addAttribute("listaUsuarioRoles", usurService.list());

		} catch (Exception e) {

			model.addAttribute("error", e.getMessage());

		}

		return "usuariorol/frmList";
	}
	
	@RequestMapping("/eliminar")
	public String deleteUsuarioRol(Map<String, Object> model, @RequestParam(value = "id") Integer id) {

		try {
			if (id != null && id > 0) {

				usurService.delete(id);
				model.put("listaUsuarioRoles", usurService.list());

			}

		} catch (Exception e) {

			model.put("error", e.getMessage());
			//revisar
			//model.put("listaProvincias", provService.list());
		}

		return "redirect:/usuariorol/listar";
	}
	
	@RequestMapping("irmodificar/{id}")
	public String goUpdateUsuarioRol(@PathVariable int id, Model model) {

		Optional<UsuarioRol> objUsur = usurService.listId(id);

		model.addAttribute("listaUsuarios", usuaService.list());
		model.addAttribute("listaRoles", roleService.list());
		model.addAttribute("ssa", objUsur.get());

		return "usuariorol/frmUpdate";
	}
	
	@PostMapping("/modificar")
	public String updateUsuarioRol(UsuarioRol ur) {

		usurService.update(ur);
		
		// el redirect:/ es para llamar a funciones dentro del Controller
		return "redirect:/usuariorol/listar";

	}
}
