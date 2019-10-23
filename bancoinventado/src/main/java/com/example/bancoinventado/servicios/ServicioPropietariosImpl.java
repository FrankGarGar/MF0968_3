package com.example.bancoinventado.servicios;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.inject.Named;

import com.example.bancoinventado.entidades.Propietario;
import com.example.bancoinventado.repositorios.jpa.PropietarioDaoJPA;

@Named
public class ServicioPropietariosImpl implements ServicioPropietarios<Propietario, Long>{
	private Logger log = Logger.getLogger("TAREASERVICE");
	@Inject
	private PropietarioDaoJPA pDao;

	@Override
	public Iterable<Propietario> getAll() {
		log.info("SI");
		log.warning(pDao.getAll().toString());
		return pDao.getAll();
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
