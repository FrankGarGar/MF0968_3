package com.example.appspringsecurity.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.appspringsecurity.entidades.Categoria;
import com.example.appspringsecurity.repositorios.jpa.CategoriaDaoJPA;
@Service
public class ServicioCategoriaImpl implements ServiciosDAOS<Categoria, Long>{
	@Inject
	private CategoriaDaoJPA catRepo;
	@Override
	public Categoria getOne(Long id) {
		return catRepo.getOne(id);
	}
	@Override
	public Iterable<Categoria> getAll() {
		return catRepo.getAll();
	}
	@Override
	public Categoria save(Categoria user) {
		return catRepo.save(user);
	}
	@Override
	public Categoria update(Categoria user) {
		return catRepo.save(user);
	}
	@Override
	public void delete(Long id) {
		catRepo.delete(id);
		
	}
	public Categoria findByNombre(String nombre) {
		return catRepo.findByNombre(nombre);
	}
}
