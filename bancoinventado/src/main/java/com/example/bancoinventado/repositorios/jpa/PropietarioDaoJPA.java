package com.example.bancoinventado.repositorios.jpa;

import javax.inject.Inject;
import javax.inject.Named;

import com.example.bancoinventado.entidades.Propietario;
import com.example.bancoinventado.repositorios.PropietarioDao;
@Named
public class PropietarioDaoJPA implements PropietarioDao{
	@Inject
	private PropietarioDaoJPA pRepo;
	
	@Override
	public Iterable<Propietario> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Propietario getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Propietario insert(Propietario objeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Propietario update(Propietario objeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<Propietario> findByNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Propietario> findByApellidos() {
		// TODO Auto-generated method stub
		return null;
	}

}
