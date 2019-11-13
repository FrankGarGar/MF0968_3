package com.francisco.proyectomf0968.repositorios;

import javax.inject.Inject;
import javax.inject.Named;

import com.francisco.proyectomf0968.entidades.Usuario;
@Named
public class UsuarioDaoJPA implements UsuarioDao{
	@Inject
	private UsuariosRepositorios pRepo;
	
	@Override
	public Iterable<Usuario> getAll() {
		return pRepo.findAll(); 
	}

	@Override
	public Usuario getOne(Long id) {
		return pRepo.findById(id).get();
	}

	@Override
	public Usuario save(Usuario usuario) {
		return pRepo.save(usuario);
	}

	@Override
	public Usuario update(Usuario usuario) {
		return pRepo.save(usuario);
	}

	@Override
	public void delete(Long id) {
		pRepo.deleteById(id);
	}
	@Override
	public Iterable<Usuario> findByNombre(String nombre) {
		return pRepo.findByNombre(nombre);
	}

	@Override
	public Iterable<Usuario> findByApellidos(String apellidos) {
		return pRepo.findByApellidos(apellidos);
	}
	public Usuario findById(Long id) {
		return pRepo.findById(id).get();
	}

	@Override
	public Usuario findByUsername(String username) {
		return pRepo.findByUsername(username);
	}
}
