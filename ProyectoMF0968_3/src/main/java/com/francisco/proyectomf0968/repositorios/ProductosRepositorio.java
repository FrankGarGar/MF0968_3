package com.francisco.proyectomf0968.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.francisco.proyectomf0968.entidades.Producto;
@RepositoryRestResource(collectionResourceRel = "productos", path = "productos")
public interface ProductosRepositorio extends CrudRepository<Producto, Long>{
	List<Producto> findByNombre(String nombre);
}
