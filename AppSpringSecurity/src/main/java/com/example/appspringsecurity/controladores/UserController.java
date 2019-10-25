package com.example.appspringsecurity.controladores;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@GetMapping(value= {"/","/home"})
	public String home(Model model,Principal principal) {
		model.addAttribute("principal",principal);
		
		return "user/home";
	}
}
