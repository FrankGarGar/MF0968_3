package com.francisco.proyectomf0968.controladores;

import java.security.Principal;
import java.util.Collection;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.francisco.proyectomf0968.entidades.Producto;
import com.francisco.proyectomf0968.servicios.ServicioProductoImpl;

@Controller
public class UserController {

	private Logger logListado = Logger.getLogger(Producto.class);
	@Autowired
	private ServicioProductoImpl servicioProductos;
	@GetMapping(value = { "/", "/home" })
	public String home(Model model, Principal principal) {
		model.addAttribute("principal", principal);
		@SuppressWarnings("unchecked")
		Collection<SimpleGrantedAuthority>  authorities= (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		model.addAttribute("role",authorities.toString().replace("[ROLE_","").replace("]",""));
		logListado.info("Ingreso a Listado de productos");
		Iterable<Producto> productos = servicioProductos.getAll();
		if(productos.toString().equals("[]")) {
			productos=null;
		}
		System.out.println(productos);
		model.addAttribute("productos",productos);
		return "home";
	}
}
