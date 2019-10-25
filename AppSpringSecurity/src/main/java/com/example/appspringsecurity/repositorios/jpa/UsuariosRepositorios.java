package com.example.appspringsecurity.repositorios.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.appspringsecurity.entidades.Usuario;
@Repository
public interface UsuariosRepositorios extends CrudRepository<Usuario, Long>{
	List<Usuario> findByNombre(String nombre);
	List<Usuario> findByApellidos(String apellidos);
	Usuario findByUsername(String username);
}
