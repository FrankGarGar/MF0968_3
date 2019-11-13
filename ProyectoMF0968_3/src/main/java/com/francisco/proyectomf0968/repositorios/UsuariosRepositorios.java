package com.francisco.proyectomf0968.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.francisco.proyectomf0968.entidades.Usuario;
@Repository
interface UsuariosRepositorios extends CrudRepository<Usuario, Long>{
	List<Usuario> findByNombre(String nombre);
	List<Usuario> findByApellidos(String apellidos);
	Usuario findByUsername(String username);
}
