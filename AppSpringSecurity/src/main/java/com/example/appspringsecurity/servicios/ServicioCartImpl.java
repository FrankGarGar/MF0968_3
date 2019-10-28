package com.example.appspringsecurity.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.appspringsecurity.entidades.Carrito;
import com.example.appspringsecurity.repositorios.jpa.CarritoJPA;
@Service
public class ServicioCartImpl {
	@Inject
	private CarritoJPA cartRepo;
	public Carrito getCart(String username) {
		return cartRepo.getAll(username);
	}
}
