package com.example.appspringsecurity.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.appspringsecurity.entidades.Categoria;
import com.example.appspringsecurity.entidades.Producto;
import com.example.appspringsecurity.repositorios.jpa.ProductoDaoJPA;
@Service
public class ServicioProductoImpl implements ServiciosDAOS<Producto, Long>{
	@Inject
	private ProductoDaoJPA catRepo;
	@Override
	public Producto getOne(Long id) {
		return catRepo.getOne(id);
	}
	@Override
	public Iterable<Producto> getAll() {
		return catRepo.getAll();
	}
	@Override
	public Producto save(Producto user) {
		return catRepo.save(user);
	}
	@Override
	public Producto update(Producto user) {
		return catRepo.save(user);
	}
	@Override
	public void delete(Long id) {
		catRepo.delete(id);
		
	}
	public Iterable<Producto> findByCategoria(Categoria cat) {
		return catRepo.findByCategoria(cat);
	}
}
