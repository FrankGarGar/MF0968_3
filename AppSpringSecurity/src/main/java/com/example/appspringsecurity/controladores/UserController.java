package com.example.appspringsecurity.controladores;

import java.security.Principal;
import java.util.HashSet;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.appspringsecurity.entidades.Carrito;
import com.example.appspringsecurity.entidades.CartItem;
import com.example.appspringsecurity.entidades.Categoria;
import com.example.appspringsecurity.entidades.Producto;
import com.example.appspringsecurity.entidades.Usuario;
import com.example.appspringsecurity.servicios.ServicioCartImpl;
import com.example.appspringsecurity.servicios.ServicioCategoriaImpl;
import com.example.appspringsecurity.servicios.ServicioProductoImpl;
import com.example.appspringsecurity.servicios.ServicioUsuarioImpl;

@Controller
@RequestMapping("/user")
public class UserController {

	private Logger logCarrito = Logger.getLogger(Carrito.class);
	@Autowired
	private ServicioCategoriaImpl servicioC;

	@Autowired
	private ServicioUsuarioImpl servicioUser;
	@Autowired
	private ServicioCartImpl servicioCart;
	@Autowired
	private ServicioProductoImpl servicioP;

	public Model getAtts(Model model, Principal principal) {
		model.addAttribute("categorias", servicioC.getAll());
		model.addAttribute("principal", principal);
		Usuario user = servicioUser.getByUsername(principal.getName());
		model.addAttribute("carrito", servicioCart.getCart(user));
		logCarrito.info("Atributos cargados correctamente");
		return model;
	}

	@GetMapping(value = { "/", "/home" })
	public String home(Model model, Principal principal) {
		model = getAtts(model, principal);
		return "user/home";
	}

	@GetMapping("/productos")
	public String productos(Model model, Principal principal) {

		model = getAtts(model, principal);
		model.addAttribute("productos", servicioP.getAll());
		logCarrito.info(principal.getName() + " esta viendo todos los productos");
		return "user/productos";
	}

	@PostMapping("/productos/addcart")
	public String addCart(Model model, Principal principal, @Valid CartItem cartItem, @RequestParam Long producto_id) {
		Producto producto = new Producto();
		producto.setId(producto_id);
		cartItem.setProducto(producto);

		Usuario user = servicioUser.getByUsername(principal.getName());
		Carrito cartExiste = servicioCart.getCart(user);

		if (cartExiste != null) {
			cartExiste.getCartItems().add(cartItem);

			servicioCart.saveCarrito(cartExiste);
		} else {
			Carrito carrito = new Carrito();
			carrito.setUsuario(user);
			carrito.setCartItems(new HashSet<CartItem>());
			carrito.getCartItems().add(cartItem);

			servicioCart.saveCarrito(carrito);

		}
		logCarrito.info(principal.getName() + " ha guardado un producto en su carrito correctamente");
		return "redirect:";
	}

	@GetMapping("/productos/delete/{id}")
	public String productos(Model model, Principal principal, @PathVariable("id") Long id) {
		try {
			model = getAtts(model, principal);
			servicioCart.deleteItem(id);
			logCarrito.info("Producto eliminado del carrito de " + principal.getName());
			return "redirect:../";
		} catch (Exception e) {
			String error = "El producto que intentas eliminar de tu carrito no existe";
			logCarrito.warn("El producto que intenta eliminar " + principal.getName() + " de tu carrito no existe");
			model.addAttribute("error", error);
		}
		return "user/home";
	}

	@GetMapping("/categorias/{nombre}")
	public String productos(Model model, Principal principal, @PathVariable("nombre") String nombre) {
		Categoria cat = servicioC.findByNombre(nombre);
		model.addAttribute("cat", nombre);
		Iterable<Producto> productosCat = servicioP.findByCategoria(cat);
		model = getAtts(model, principal);

		if (productosCat.toString().equals("[]")) {
			productosCat = null;
		}
		model.addAttribute("productosCat", productosCat);

		logCarrito.info(principal.getName() + " esta viendo todos los productos segun categoria " + nombre);
		return "user/categorias";
	}
}
