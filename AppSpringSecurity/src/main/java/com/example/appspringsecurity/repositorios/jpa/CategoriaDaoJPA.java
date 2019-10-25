package com.example.appspringsecurity.repositorios.jpa;

import javax.inject.Inject;
import javax.inject.Named;

import com.example.appspringsecurity.entidades.Categoria;
import com.example.appspringsecurity.repositorios.Dao;

@Named
public class CategoriaDaoJPA implements Dao<Categoria, Long>{
	
	@Inject
	private CategoriaRepositorio catRepo;
	@Override
	public Iterable<Categoria> getAll() {
		return catRepo.findAll();
	}

	@Override
	public Categoria getOne(Long id) {
		return catRepo.findById(id).get();
	}

	@Override
	public Categoria save(Categoria categoria) {
		return catRepo.save(categoria);
	}

	@Override
	public Categoria update(Categoria categoria) {
		return catRepo.save(categoria);
	}

	@Override
	public void delete(Long id) {
		catRepo.deleteById(id);
	}

}
