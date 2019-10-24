package com.example.appspringsecurity.repositorios;

import com.example.appspringsecurity.entidades.Usuario;

public interface UsuarioDao extends Dao<Usuario, Long>{
	Iterable<Usuario> findByNombre(String nombre);
	Iterable<Usuario> findByApellidos(String apellidos);
	Usuario findByUsername(String username);
}
