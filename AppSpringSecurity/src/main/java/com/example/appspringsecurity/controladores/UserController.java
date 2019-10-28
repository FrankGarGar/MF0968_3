package com.example.appspringsecurity.controladores;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.appspringsecurity.entidades.Carrito;
import com.example.appspringsecurity.servicios.ServicioCartImpl;
import com.example.appspringsecurity.servicios.ServicioCategoriaImpl;
import com.example.appspringsecurity.servicios.ServicioProductoImpl;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private ServicioCategoriaImpl servicioC;
	@Autowired
	private ServicioCartImpl servicioCart;
	@Autowired
	private ServicioProductoImpl servicioP;
	public Model getAtts(Model model,Principal principal) {
		model.addAttribute("categorias",servicioC.getAll());
		model.addAttribute("carrito",servicioCart.getCart(principal.getName()));
		return model;
	}
	@GetMapping(value= {"/","/home"})
	public String home(Model model,Principal principal) {
		model.addAttribute("principal",principal);
		model = getAtts(model,principal);
		return "user/home";
	}
	@GetMapping("/productos")
	public String productos(Model model,Principal principal) {

		model.addAttribute("principal",principal);
		model = getAtts(model,principal);
		model.addAttribute("productos",servicioP.getAll());
		return "user/productos";
	}
	@PostMapping("/productos/addcart")
	public String addCart(Model model,Principal principal/*,@Valid Carrito carrito*/) {
		System.out.println(principal);
		return "redirect:user/productos";
	}
}
