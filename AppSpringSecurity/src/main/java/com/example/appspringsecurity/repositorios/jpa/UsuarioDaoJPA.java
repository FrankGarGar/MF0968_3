package com.example.appspringsecurity.repositorios.jpa;

import javax.inject.Inject;
import javax.inject.Named;

import com.example.appspringsecurity.entidades.Usuario;
import com.example.appspringsecurity.repositorios.UsuarioDao;
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
	public Usuario save(Usuario Propietario) {
		Propietario.setId(null);
		return pRepo.save(Propietario);
	}

	@Override
	public Usuario update(Usuario Propietario) {
		return pRepo.save(Propietario);
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
