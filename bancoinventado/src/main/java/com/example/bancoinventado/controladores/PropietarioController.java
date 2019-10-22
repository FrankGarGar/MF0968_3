package com.example.bancoinventado.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.bancoinventado.servicios.ServicioPropietariosImpl;

@Controller
public class PropietarioController {
	@Inject
	private ServicioPropietariosImpl servicioPropietarios;
	@GetMapping("/propietarios")
	public String getAll(Model model) {
		model.addAttribute("propietarios",servicioPropietarios.getAll());
		return "propietarios";
	}
}
