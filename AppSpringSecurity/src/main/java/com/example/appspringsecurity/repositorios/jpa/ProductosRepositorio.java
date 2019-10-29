package com.example.appspringsecurity.repositorios.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.appspringsecurity.entidades.Categoria;
import com.example.appspringsecurity.entidades.Producto;
@Repository
public interface ProductosRepositorio extends CrudRepository<Producto, Long>{
	List<Producto> findByCategoria(Categoria cat);
	List<Producto> findByNombre(String nombre);
	Producto findByCodigo(String codigo);
}
