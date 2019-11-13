package com.francisco.proyectomf0968.repositorios;

import javax.inject.Inject;
import javax.inject.Named;

import com.francisco.proyectomf0968.entidades.Producto;
@Named
public class ProductoDaoJPA implements Dao<Producto, Long>{
	@Inject 
	private ProductosRepositorio prodsRepo;
	@Override
	public Iterable<Producto> getAll() {
		return prodsRepo.findAll();
	}

	@Override
	public Producto getOne(Long id) {
		return prodsRepo.findById(id).get();
	}

	@Override
	public Producto save(Producto producto) {
		return prodsRepo.save(producto);
	}

	@Override
	public Producto update(Producto producto) {
		return prodsRepo.save(producto);
	}

	@Override
	public void delete(Long id) {
		prodsRepo.deleteById(id);
	}

}
