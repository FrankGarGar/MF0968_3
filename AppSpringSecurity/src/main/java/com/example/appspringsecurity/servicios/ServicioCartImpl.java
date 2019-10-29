package com.example.appspringsecurity.servicios;

import java.util.HashSet;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.appspringsecurity.entidades.Carrito;
import com.example.appspringsecurity.entidades.CartItem;
import com.example.appspringsecurity.entidades.Usuario;
import com.example.appspringsecurity.repositorios.jpa.CarritoJPA;
import com.example.appspringsecurity.repositorios.jpa.CartItemDaoJPA;
@Service
public class ServicioCartImpl {
	@Inject
	private CarritoJPA cartRepo;
	@Inject CartItemDaoJPA cartItemsRepo;
	public Carrito getCart(Usuario user) {
		return cartRepo.getAll(user);
	}
	public Carrito saveCarrito(Carrito carrito) {
		Iterable<CartItem> cartItems = cartItemsRepo.saveAll(carrito.getCartItems());
		carrito.setCartItems(new HashSet<CartItem>());
		for (CartItem cartItem : cartItems) {
			carrito.getCartItems().add(cartItem);
		}
		return cartRepo.save(carrito);
		
	}
	public void deleteItem(Long id) {
		cartItemsRepo.delete(id);
		
	}
}
