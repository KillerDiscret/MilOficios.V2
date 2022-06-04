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
import pe.edu.upc.demo.serviceinterface.IRolService;

@Controller
@RequestMapping("/rol")
public class RolController {

	@Autowired
	private IRolService roleService;

	@GetMapping("/nuevo")
	public String newRol(Model model) {

		model.addAttribute("r", new Rol());

		return "rol/frmRegister";
	}

	@PostMapping("/guardar")
	public String saveRol(@Valid Rol ro, BindingResult binRes, Model model) {

		if (binRes.hasErrors()) {

			model.addAttribute("error", "Ocurrió un error!");
			return "rol/frmRegister";

		} else {

			roleService.insert(ro);
			model.addAttribute("mensaje", "Se guardó correctamente!");
			return "redirect:/rol/listar";
		}
	}

	@GetMapping("/listar")
	public String listRol(Model model) {

		try {

			model.addAttribute("listaRoles", roleService.list());

		} catch (Exception e) {

			model.addAttribute("error", e.getMessage());

		}

		return "rol/frmList";
	}

	@RequestMapping("/eliminar")
	public String deleteDepartamento(Map<String, Object> model, @RequestParam(value = "id") Integer id) {

		try {
			if (id != null && id > 0) {

				roleService.delete(id);
				model.put("listaRoles", roleService.list());

			}

		} catch (Exception e) {

			model.put("error", e.getMessage());
		}

		return "redirect:/rol/listar";
	}

	@RequestMapping("irmodificar/{id}")
	public String goUpdateRol(@PathVariable int id, Model model) {

		Optional<Rol> objRole = roleService.listId(id);

		model.addAttribute("rsa", objRole.get());

		return "rol/frmUpdate";
	}

	@PostMapping("/modificar")
	public String updateRol(Rol ro) {

		roleService.update(ro);

		// el redirect:/ es para llamar a funciones dentro del Controller
		return "redirect:/rol/listar";

	}

}
