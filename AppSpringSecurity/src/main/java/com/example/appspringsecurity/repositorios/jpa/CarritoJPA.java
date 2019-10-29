package com.example.appspringsecurity.repositorios.jpa;

import javax.inject.Inject;
import javax.inject.Named;

import com.example.appspringsecurity.entidades.Carrito;
import com.example.appspringsecurity.entidades.Usuario;
@Named
public class CarritoJPA {
	@Inject
	private CarritoRepositorio cartRepo;
	public Carrito getAll(Usuario user) {
		return cartRepo.findByUsuario(user);
	}
	public Carrito save(Carrito carrito) {
		
		return cartRepo.save(carrito);
	}
}
