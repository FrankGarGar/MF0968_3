package com.francisco.proyectomf0968.repositorios;

import com.francisco.proyectomf0968.entidades.Usuario;

public interface UsuarioDao extends Dao<Usuario, Long>{
	Iterable<Usuario> findByNombre(String nombre);
	Iterable<Usuario> findByApellidos(String apellidos);
	Usuario findByUsername(String username);
}
