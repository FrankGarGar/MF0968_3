package com.francisco.apirestjs.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.francisco.apirestjs.entidades.Pais;

@RepositoryRestResource(collectionResourceRel = "paises", path = "paises")
public interface PaisesRepositorio extends PagingAndSortingRepository<Pais, Long>{

}
