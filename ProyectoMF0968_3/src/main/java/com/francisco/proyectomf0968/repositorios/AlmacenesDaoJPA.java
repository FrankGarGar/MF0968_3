package com.francisco.proyectomf0968.repositorios;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.francisco.proyectomf0968.entidades.Almacen;

@Named
public class AlmacenesDaoJPA implements Dao<Almacen, Long>{
	@Autowired
	private AlmacenesRepositorio almacenesRepo;

	@Override
	public Iterable<Almacen> getAll() {
		return almacenesRepo.findAll();
	}

	@Override
	public Almacen getOne(Long id) {
		return almacenesRepo.findById(id).get();
	}

	@Override
	public Almacen save(Almacen producto) {
		return almacenesRepo.save(producto);
	}

	@Override
	public Almacen update(Almacen producto) {
		return almacenesRepo.save(producto);
	}

	@Override
	public void delete(Long id) {
		almacenesRepo.deleteById(id);
	}

}
