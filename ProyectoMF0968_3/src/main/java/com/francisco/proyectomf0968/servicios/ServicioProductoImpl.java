package com.francisco.proyectomf0968.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francisco.proyectomf0968.entidades.Producto;
import com.francisco.proyectomf0968.repositorios.ProductoDaoJPA;
@Service
public class ServicioProductoImpl implements ServiciosCRUD<Producto, Long>{
	
	@Autowired
	private ProductoDaoJPA prodsRepo;
	
	@Override
	public Producto getOne(Long id) {
		return prodsRepo.getOne(id);
	}

	@Override
	public Iterable<Producto> getAll() {
		return prodsRepo.getAll();
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
		prodsRepo.delete(id);
	}

}
