package com.example.appspringsecurity.controladores;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.appspringsecurity.entidades.Categoria;
import com.example.appspringsecurity.entidades.Producto;
import com.example.appspringsecurity.entidades.Usuario;
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
	
	@Autowired
	private BCryptPasswordEncoder pEncoder;
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
		/*CREAR*/
			@GetMapping("/usuarios/create")
			public String usuariosAddGet(Model model) {
				
				return "admin/forms/createUsuario";
			}
			@PostMapping("/usuarios/create")
			public String usuariosAddPost(Model model,@Valid Usuario user) {
				user.setRole("ADMIN");
				user.setPassword(pEncoder.encode(user.getPassword()));
				user = servicioU.save(user);

				return "redirect:../usuarios";
			}
		/*EDITAR*/
			@GetMapping("/usuarios/edit/{id}")
			public String usuariosEditGet(Model model,@PathVariable("id") String id) {
				model.addAttribute("usuario",servicioU.getOne(Long.parseLong(id)));
				return "admin/forms/createUsuario";
			}
			@PostMapping("/usuarios/edit")
			public String usuariosEditPost(Model model,@Valid Usuario user) {
				user.setPassword(pEncoder.encode(user.getPassword()));
				user = servicioU.save(user);
				
				return "redirect:../usuarios";
			}
		/*ELIMINAR*/
			@GetMapping("/usuarios/delete/{id}")
			public String usuariosDelete(Model model,@PathVariable("id") String id) {
				servicioU.delete(Long.parseLong(id));

				return "redirect:../../usuarios";
			}
	/****************END MAPPING USUARIOS*************************/
	
	/***************START MAPPING PRODUCTOS***********************/
		@GetMapping("/productos")
		public String productos(Model model) {
			
			model.addAttribute("productos",servicioP.getAll());
			return "admin/productos";
		}
		/*CREAR*/
			@GetMapping("/productos/create")
			public String productosAddGet(Model model) {
				model.addAttribute("categorias",servicioC.getAll());
				return "admin/forms/createProducto";
			}
			@PostMapping("/productos/create")
			public String productosAddPost(Model model,@Valid Producto producto) {
				producto = servicioP.save(producto);
	
				return "redirect:../productos";
			}
		/*EDITAR*/
			@GetMapping("/productos/edit/{id}")
			public String productosEditGet(Model model,@PathVariable("id") String id) {
				model.addAttribute("producto",servicioP.getOne(Long.parseLong(id)));
				model.addAttribute("categorias",servicioC.getAll());
				return "admin/forms/createProducto";
			}
			@PostMapping("/productos/edit")
			public String productosEditPost(Model model,@Valid Producto producto) {
				producto = servicioP.save(producto);
				
				return "redirect:../productos";
			}
		/*ELIMINAR*/
			@GetMapping("/productos/delete/{id}")
			public String productosDelete(Model model,@PathVariable("id") String id) {
				servicioP.delete(Long.parseLong(id));
	
				return "redirect:../../productos";
			}
	/***************END MAPPING PRODUCTOS***********************/
	
	/***************START MAPPING CATEGORIAS***********************/
	@GetMapping("/categorias")
	public String categorias(Model model) {
		model.addAttribute("categorias",servicioC.getAll());
		return "admin/categorias";
	}
	/*CREAR*/
		@GetMapping("/categorias/create")
		public String categoriasAddGet(Model model) {
			
			return "admin/forms/createCategoria";
		}
		@PostMapping("/categorias/create")
		public String categoriasAddPost(Model model,@Valid Categoria categoria) {
			categoria = servicioC.save(categoria);
	
			return "redirect:../categorias";
		}
	/*EDITAR*/
		@GetMapping("/categorias/edit/{id}")
		public String categoriasEditGet(Model model,@PathVariable("id") String id) {
			model.addAttribute("categoria",servicioC.getOne(Long.parseLong(id)));
			return "admin/forms/createCategoria";
		}
		@PostMapping("/categorias/edit")
		public String categoriasEditPost(Model model,@Valid Categoria categoria) {
			categoria = servicioC.save(categoria);
			
			return "redirect:../categorias";
		}
	/*ELIMINAR*/
		@GetMapping("/categorias/delete/{id}")
		public String categoriasDelete(Model model,@PathVariable("id") String id) {
			servicioC.delete(Long.parseLong(id));
	
			return "redirect:../../categorias";
		}
	/***************END MAPPING CATEGORIAS***********************/
}
