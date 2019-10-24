package com.example.appspringsecurity.repositorios.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.appspringsecurity.entidades.Usuario;

public interface UsuariosRepositorios extends CrudRepository<Usuario, Long>{
	List<Usuario> findByNombre(String nombre);
	List<Usuario> findByApellidos(String apellidos);
	Usuario findByUsername(String username);
}
