package com.francisco.proyectomf0968.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francisco.proyectomf0968.entidades.Almacen;
import com.francisco.proyectomf0968.repositorios.AlmacenesDaoJPA;
@Service
public class ServicioAlmacenImpl implements ServiciosCRUD<Almacen,Long>{
	@Autowired
	private AlmacenesDaoJPA almacenesRepo;
	@Override
	public Almacen getOne(Long id) {
		return almacenesRepo.getOne(id);
	}

	@Override
	public Iterable<Almacen> getAll() {
		return almacenesRepo.getAll();
	}

	@Override
	public Almacen save(Almacen almacen) {
		return almacenesRepo.save(almacen);
	}

	@Override
	public Almacen update(Almacen almacen) {
		return almacenesRepo.save(almacen);
	}

	@Override
	public void delete(Long id) {
		almacenesRepo.delete(id);
	}

}
