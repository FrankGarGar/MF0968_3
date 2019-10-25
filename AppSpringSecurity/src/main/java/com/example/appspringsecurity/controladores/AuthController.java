package com.example.appspringsecurity.controladores;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.view.RedirectView;

import com.example.appspringsecurity.entidades.Usuario;
import com.example.appspringsecurity.servicios.ServicioUsuarioImpl;

@Controller
public class AuthController {
	@Inject
	private ServicioUsuarioImpl servicioU;
	@Inject
	private BCryptPasswordEncoder pEncoder;
	@GetMapping("/login")
	public String loginUser() {
		return "login";
	}

	@GetMapping("/register")
	public String registerUser () {
		return "register";
	}
	@PostMapping("/register")
	public RedirectView registerUser (@ModelAttribute("user") @Valid Usuario user, 
			BindingResult result, WebRequest request, Errors errors){
		user.setPassword(pEncoder.encode(user.getPassword()));
		user.setRole("USER");
		user = servicioU.save(user);
		return new RedirectView("login");
	}
}
