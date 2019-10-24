package com.example.appspringsecurity.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

import com.example.appspringsecurity.entidades.Usuario;

@Controller
public class AuthController {

	@GetMapping("/login")
	public String loginUser() {

		return "login";
	}

	@GetMapping("/registro")
	public String registerUser (WebRequest request, Model model){
		Usuario user = new Usuario();
		model.addAttribute("user", user);
		return "registro";
	}
}
