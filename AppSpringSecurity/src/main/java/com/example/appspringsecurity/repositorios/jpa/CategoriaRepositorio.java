package com.example.appspringsecurity.repositorios.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.appspringsecurity.entidades.Categoria;
@Repository
public interface CategoriaRepositorio extends CrudRepository<Categoria, Long>{
	Categoria findByNombre(String nombre);
}
