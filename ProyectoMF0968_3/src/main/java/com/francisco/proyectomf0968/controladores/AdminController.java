package com.francisco.proyectomf0968.controladores;

import java.security.Principal;
import java.util.Collection;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.francisco.proyectomf0968.entidades.Producto;
import com.francisco.proyectomf0968.entidades.Usuario;
import com.francisco.proyectomf0968.modelos.Alerta;
import com.francisco.proyectomf0968.servicios.ServicioProductoImpl;

@Controller
public class AdminController {
	private Logger logUsuario = Logger.getLogger(Usuario.class);
	@Autowired
	private ServicioProductoImpl servicioProductos;
	
	@GetMapping("/mantenimiento-productos")
	public String matenimientoProductos(Model model, Principal principal) {
		model.addAttribute("principal", principal);
		@SuppressWarnings("unchecked")
		Collection<SimpleGrantedAuthority>  authorities= (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		model.addAttribute("role",authorities.toString().replace("[ROLE_","").replace("]",""));
		logUsuario.info("Ingreso a Mantenimiento de productos");
		Iterable<Producto> productos = servicioProductos.getAll();
		if(productos.toString().equals("[]")) {
			productos=null;
		}
		
		model.addAttribute("productos",productos);
		return "mantenimiento-productos";
	}
	@GetMapping("/add-producto")
	public String matenimientoProductosFormAgregar(Model model, Principal principal,Producto producto) {
		model.addAttribute("principal", principal);
		@SuppressWarnings("unchecked")
		Collection<SimpleGrantedAuthority>  authorities= (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		model.addAttribute("role",authorities.toString().replace("[ROLE_","").replace("]",""));
		logUsuario.info("Ingreso a Mantenimiento de productos");
		
		return "add-producto";
	}
	@GetMapping("/add-producto/{id}")
	public String matenimientoProductosFormedit(Model model, Principal principal,Producto producto,@PathVariable("id") Long id) {
		model.addAttribute("principal", principal);
		@SuppressWarnings("unchecked")
		Collection<SimpleGrantedAuthority>  authorities= (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		model.addAttribute("role",authorities.toString().replace("[ROLE_","").replace("]",""));
		logUsuario.info("Ingreso a Mantenimiento de productos");
		producto = servicioProductos.getOne(id);
		model.addAttribute("producto",producto);
		return "add-producto";
	}
	@GetMapping("/delete-producto/{id}")
	public String matenimientoProductosDelete(Model model, Principal principal,@PathVariable("id") Long id,RedirectAttributes attrs) {
		model.addAttribute("principal", principal);
		@SuppressWarnings("unchecked")
		Collection<SimpleGrantedAuthority>  authorities= (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		model.addAttribute("role",authorities.toString().replace("[ROLE_","").replace("]",""));
		logUsuario.info("Ingreso a Mantenimiento de productos");
		servicioProductos.delete(id);
		logUsuario.info("Producto eliminado");
		Alerta alerta = new Alerta();
		alerta.setTexto("Eliminado correctamente");
		alerta.setNivel("success");
		attrs.addFlashAttribute(alerta);
		return "redirect:/mantenimiento-productos";
	}
	@PostMapping("/add-producto")
	public String matenimientoProductosAgregar(Model model, Principal principal,@Valid Producto producto, BindingResult bindingResult,RedirectAttributes attrs) {
		Alerta alerta = new Alerta();
		if(bindingResult.hasErrors()) {
			alerta.setTexto("Error al validar");
			alerta.setNivel("warning");
			
			model.addAttribute("alerta", alerta);
			logUsuario.info("Fallo al crear producto nuevo no paso validacion");
			return "add-producto";
		}
		logUsuario.info("Agregando producto nuevo");
		alerta.setTexto("Insertado correctamente");
		alerta.setNivel("success");
		servicioProductos.save(producto);
		attrs.addFlashAttribute(alerta);
		return "redirect:/mantenimiento-productos";
	}
	@GetMapping("/mantenimiento-remoto")
	public String matenimientoProductosRemoto(Model model, Principal principal) {
		return "mantenimiento-remoto";
	}
}
