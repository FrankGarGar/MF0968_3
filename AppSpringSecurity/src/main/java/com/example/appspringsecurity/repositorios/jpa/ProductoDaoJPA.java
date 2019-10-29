package com.example.appspringsecurity.repositorios.jpa;

import javax.inject.Inject;
import javax.inject.Named;

import com.example.appspringsecurity.entidades.Categoria;
import com.example.appspringsecurity.entidades.Producto;
import com.example.appspringsecurity.repositorios.Dao;
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

	public Iterable<Producto> findByCategoria(Categoria cat) {
		return prodsRepo.findByCategoria(cat);
	}

}
