package com.example.appspringsecurity.repositorios.jpa;

import org.springframework.data.repository.CrudRepository;

import com.example.appspringsecurity.entidades.Carrito;
import com.example.appspringsecurity.entidades.Usuario;

public interface CarritoRepositorio extends CrudRepository<Carrito, Long>{
	Carrito findByUsuario(Usuario usuario);
}
