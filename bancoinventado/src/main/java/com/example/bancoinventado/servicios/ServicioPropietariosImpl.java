package com.example.bancoinventado.servicios;

import javax.inject.Inject;
import javax.inject.Named;

import com.example.bancoinventado.entidades.Propietario;
import com.example.bancoinventado.repositorios.PropietarioDao;

@Named
public class ServicioPropietariosImpl implements ServicioPropietarios<Propietario, Long>{
	@Inject
	private PropietarioDao pDao;

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
	
	
}
