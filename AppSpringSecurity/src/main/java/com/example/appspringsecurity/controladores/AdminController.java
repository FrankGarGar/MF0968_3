package com.example.appspringsecurity.controladores;

import java.security.Principal;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
	private Logger logUsuario = Logger.getLogger(Usuario.class);
	private Logger logProducto = Logger.getLogger(Producto.class);
	private Logger logCategoria = Logger.getLogger(Categoria.class);
	@GetMapping(value = { "/", "/home" })
	public String home(Model model, Principal principal) {

		return "admin/home";
	}

	/*************** START MAPPING USUARIOS ***********************/
	@GetMapping("/usuarios")
	public String usuarios(Model model) {
		logUsuario.info("Mostrando usuarios");
		model.addAttribute("usuarios", servicioU.getAll());
		return "admin/usuarios";
	}

	/* CREAR */
	@GetMapping("/usuarios/create")
	public String usuariosAddGet(Model model) {
		logUsuario.info("Se ha mostrado el formulario de creacion de usuarios");
		return "admin/forms/createUsuario";
	}

	@PostMapping("/usuarios/create")
	public String usuariosAddPost(Model model, @Valid Usuario user) {
		user.setRole("ADMIN");
		user.setPassword(pEncoder.encode(user.getPassword()));
		user = servicioU.save(user);
		logUsuario.info("Usuario guardado correctamente!");
		return "redirect:../usuarios";
	}

	/* EDITAR */
	@GetMapping("/usuarios/edit/{id}")
	public String usuariosEditGet(Model model, @PathVariable("id") String id) {
		model.addAttribute("usuario", servicioU.getOne(Long.parseLong(id)));
		logUsuario.info("Mostrando Formulario de edicion de usuario");
		return "admin/forms/createUsuario";
	}

	@PostMapping("/usuarios/edit")
	public String usuariosEditPost(Model model, @Valid Usuario user) {
		try {
			user.setPassword(pEncoder.encode(user.getPassword()));
			user = servicioU.save(user);
			logUsuario.info("Usuario editado correctamente");
			return "redirect:../usuarios";
		} catch (NoSuchElementException e) {
			model.addAttribute("error", "El Usuario que intentas editar no existe");
			logUsuario.warn("El usuario que se intento editar no existe");
		}
		model.addAttribute("usuarios", servicioU.getAll());
		return "admin/usuarios";
	}

	/* ELIMINAR */
	@GetMapping("/usuarios/delete/{id}")
	public String usuariosDelete(Model model, @PathVariable("id") String id) {
		try {
			servicioU.delete(Long.parseLong(id));
			logUsuario.info("Usuario eliminado correctamente");
			return "redirect:../";
		} catch (EmptyResultDataAccessException e) {
			model.addAttribute("error", "El usuario que intentas eliminar no existe");
			logUsuario.warn("El usuario que se intento eliminar no existe");
		}
		model.addAttribute("usuarios", servicioU.getAll());
		return "admin/usuarios";
	}

	/**************** END MAPPING USUARIOS *************************/

	/*************** START MAPPING PRODUCTOS ***********************/
	@GetMapping("/productos")
	public String productos(Model model) {
		logProducto.info("Mostrando todos los productos");
		model.addAttribute("productos", servicioP.getAll());
		return "admin/productos";
	}

	/* CREAR */
	@GetMapping("/productos/create")
	public String productosAddGet(Model model) {
		model.addAttribute("categorias", servicioC.getAll());
		logProducto.info("Mostrando formulacrio de creacion de productos");
		return "admin/forms/createProducto";
	}

	@PostMapping("/productos/create")
	public String productosAddPost(Model model, @Valid Producto producto) {
		producto = servicioP.save(producto);
		logProducto.info("Nuevo producto agregado satisfactoriamente!");
		return "redirect:../productos";
	}

	/* EDITAR */
	@GetMapping("/productos/edit/{id}")
	public String productosEditGet(Model model, @PathVariable("id") String id) {
		try {
			model.addAttribute("producto", servicioP.getOne(Long.parseLong(id)));
			model.addAttribute("categorias", servicioC.getAll());
			logProducto.info("Producto editado con éxito");
			return "admin/forms/createProducto";
		} catch (NoSuchElementException e) {
			model.addAttribute("error", "El producto que intentas editar no existe!");
			logProducto.warn("El producto que intentas editar no existe!");
		}
		model.addAttribute("productos", servicioP.getAll());
		return "admin/productos";
	}

	@PostMapping("/productos/edit")
	public String productosEditPost(Model model, @Valid Producto producto) {
		producto = servicioP.save(producto);
		logProducto.info("Mostrando formulario de edicion de producto");
		return "redirect:../productos";
	}

	/* ELIMINAR */
	@GetMapping("/productos/delete/{id}")
	public String productosDelete(Model model, @PathVariable("id") String id) {
		try {
			servicioP.delete(Long.parseLong(id));
			logProducto.info("Producto eliminado corectamente!");
			return "redirect:../";
		} catch (EmptyResultDataAccessException e) {
			model.addAttribute("error", "El producto que intentas eliminar no existe");
			logProducto.warn("El producto que intentas eliminar no existe");
		}
		model.addAttribute("productos", servicioP.getAll());
		return "admin/productos";
	}

	/*************** END MAPPING PRODUCTOS ***********************/

	/*************** START MAPPING CATEGORIAS ***********************/
	@GetMapping("/categorias")
	public String categorias(Model model) {
		model.addAttribute("categorias", servicioC.getAll());
		logCategoria.info("Listado de categorias mostradas correctamente!");
		return "admin/categorias";
	}

	/* CREAR */
	@GetMapping("/categorias/create")
	public String categoriasAddGet(Model model) {
		logCategoria.info("Mostrando formulario de creación de categorias!");
		return "admin/forms/createCategoria";
	}

	@PostMapping("/categorias/create")
	public String categoriasAddPost(Model model, @Valid Categoria categoria) {
		categoria = servicioC.save(categoria);
		logCategoria.info("Categoria guardada correctamente!");
		return "redirect:../";
	}

	/* EDITAR */
	@GetMapping("/categorias/edit/{id}")
	public String categoriasEditGet(Model model, @PathVariable("id") String id) {
		try {
			model.addAttribute("categoria", servicioC.getOne(Long.parseLong(id)));
			logCategoria.info("Mostrando formulario de edición de categoria!");
			return "admin/forms/createCategoria";

		} catch (NoSuchElementException e) {
			model.addAttribute("error", "La categoria que intentas editar no existe");
			logCategoria.warn("La categoria que intentas editar no existe!");
		}
		model.addAttribute("categorias", servicioC.getAll());
		return "admin/productos";
	}

	@PostMapping("/categorias/edit")
	public String categoriasEditPost(Model model, @Valid Categoria categoria) {
		categoria = servicioC.save(categoria);
		logCategoria.info("Categoria modificada correctamente");
		return "redirect:../categorias";
	}

	/* ELIMINAR */
	@GetMapping("/categorias/delete/{id}")
	public String categoriasDelete(Model model, @PathVariable("id") String id) {
		try {
			servicioC.delete(Long.parseLong(id));
			logCategoria.info("Categoria eliminada correctamente!");
			return "redirect:../";
		} catch (EmptyResultDataAccessException e) {
			model.addAttribute("error", "La categoria que intentas eliminar no existe!");
			logCategoria.warn("La categoria que intentas eliminar no existe!");
		}
		model.addAttribute("categorias", servicioC.getAll());
		return "admin/categorias";
	}
	/*************** END MAPPING CATEGORIAS ***********************/
}
