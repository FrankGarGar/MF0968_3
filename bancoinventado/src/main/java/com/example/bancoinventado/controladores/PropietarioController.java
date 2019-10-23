package com.example.bancoinventado.controladores;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.bancoinventado.entidades.Propietario;
import com.example.bancoinventado.servicios.ServicioPropietariosImpl;

@Controller
@SessionAttributes("autenticado")
public class PropietarioController {
	private static final Logger log = LoggerFactory.getLogger(PropietarioController.class);

	@Inject
	private ServicioPropietariosImpl servicioPropietarios;
	
	@ModelAttribute("autenticado")
	public Propietario todos() {
	    return new Propietario();
	}
	
	@GetMapping("/admin/propietarios")
	public String getAll(Model model) {
		model.addAttribute("propietarios",servicioPropietarios.getAll());
		return "propietarios";
	}
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	/*@GetMapping("/login")
	public String loginUser(Model model,@ModelAttribute("autenticado") Propietario propietariolog) {
		if(propietariolog.getUsuario()==null || propietariolog.getRole()==null) {
			log.info("SI");
			log.info(propietariolog.toString());
		}
		return "login";
	}
	@PostMapping("/login")
	public String loginUserPost(Model model,@ModelAttribute("autenticado") Propietario propietariolog,@Valid Propietario p) {
		if(propietariolog.getUsuario()==null || propietariolog.getRole()==null &&
				(p.getUsuario()!=null || !p.getUsuario().equals("") && 
				p.getPassword()!=null || !p.getPassword().equals(""))) {
			propietariolog=p;
			log.info(propietariolog.toString());
			return "redirect:/home";
		}
		System.out.println("NO");
		return "login";
	}*/
}
