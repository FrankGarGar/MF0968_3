package com.example.appspringsecurity.controladores;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.appspringsecurity.servicios.ServicioCategoriaImpl;
import com.example.appspringsecurity.servicios.ServicioProductoImpl;
import com.example.appspringsecurity.servicios.ServicioUsuarioImpl;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private ServicioUsuarioImpl servicioU;
	
	@Autowired
	private ServicioCategoriaImpl servicioC;
	
	@Autowired
	private ServicioProductoImpl servicioP;
	@GetMapping(value= {"/","/home"})
	public String home(Model model,Principal principal) {

		
		return "admin/home";
	}
	/***************START MAPPING USUARIOS***********************/
	@GetMapping("/usuarios")
	public String usuarios(Model model) {
		model.addAttribute("usuarios",servicioU.getAll());
		return "admin/usuarios";
	}
	/****************END MAPPING USUARIOS*************************/
	
	/***************START MAPPING PRODUCTOS***********************/
	@GetMapping("/productos")
	public String productos(Model model) {
		
		model.addAttribute("productos",servicioP.getAll());
		return "admin/productos";
	}
	/***************END MAPPING PRODUCTOS***********************/
	
	/***************START MAPPING CATEGORIAS***********************/
	@GetMapping("/categorias")
	public String categorias(Model model) {
		model.addAttribute("categorias",servicioC.getAll());
		return "admin/categorias";
	}
	/***************END MAPPING CATEGORIAS***********************/
}
