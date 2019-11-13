package com.francisco.proyectomf0968.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.francisco.proyectomf0968.entidades.Almacen;
@RepositoryRestResource(collectionResourceRel = "almacenes", path = "almacenes")
public interface AlmacenesRepositorio extends PagingAndSortingRepository<Almacen, Long>{

}
