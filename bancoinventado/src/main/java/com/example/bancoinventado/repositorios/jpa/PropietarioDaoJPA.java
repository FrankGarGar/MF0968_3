package com.example.bancoinventado.repositorios.jpa;

import javax.inject.Inject;
import javax.inject.Named;

import com.example.bancoinventado.entidades.Propietario;
import com.example.bancoinventado.repositorios.PropietarioDao;
@Named
public class PropietarioDaoJPA implements PropietarioDao{
	@Inject
	private PropietariosRepositorios pRepo;
	
	@Override
	public Iterable<Propietario> getAll() {
		return pRepo.findAll(); 
	}

	@Override
	public Propietario getOne(Long id) {
		return pRepo.findById(id).get();
	}

	@Override
	public Propietario insert(Propietario Propietario) {
		Propietario.setId(null);
		return pRepo.save(Propietario);
	}

	@Override
	public Propietario update(Propietario Propietario) {
		return pRepo.save(Propietario);
	}

	@Override
	public void delete(Long id) {
		pRepo.deleteById(id);
	}
	@Override
	public Iterable<Propietario> findByNombre(String nombre) {
		return pRepo.findByNombre(nombre);
	}

	@Override
	public Iterable<Propietario> findByApellidos(String apellidos) {
		return pRepo.findByApellidos(apellidos);
	}
	public Propietario findById(Long id) {
		return pRepo.findById(id).get();
	}
}
