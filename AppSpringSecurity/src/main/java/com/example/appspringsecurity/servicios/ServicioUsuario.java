package com.example.appspringsecurity.servicios;

import com.example.appspringsecurity.entidades.Usuario;

public interface ServicioUsuario {
	public Usuario getOne(Long id);
	public Iterable<Usuario> getAll();
	public Usuario save(Usuario user);
	public Usuario update(Usuario user);
	public void delete(Long id);
}
