package com.francisco.proyectomf0968.controladores;

import java.security.Principal;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.francisco.proyectomf0968.entidades.Producto;
import com.francisco.proyectomf0968.servicios.ServicioProductoImpl;

@Controller
public class AllUsersController {
	private Logger logListado = Logger.getLogger(Producto.class);
	@Autowired
	private ServicioProductoImpl servicioProductos;
	@GetMapping("/listado-productos")
	public String listadoProductos(Model model, Principal principal) {
		logListado.info("INGRESO A LISTADO DE PRODUCTOS");

		model.addAttribute("productos",servicioProductos.getAll());
		return "listado-productos";
	}
	
}
