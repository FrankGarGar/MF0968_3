package com.example.appspringsecurity.repositorios.jpa;

import javax.inject.Inject;
import javax.inject.Named;

import com.example.appspringsecurity.entidades.Carrito;
import com.example.appspringsecurity.entidades.Usuario;
@Named
public class CarritoJPA {
	@Inject
	private CarritoRepositorio cartRepo;
	@Inject
	private UsuariosRepositorios userRepo;
	public Carrito getAll(String username) {
		Usuario usuario = userRepo.findByUsername(username);
		return cartRepo.findByUsuario(usuario);
	}
}
