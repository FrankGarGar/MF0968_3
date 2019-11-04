package com.francisco.apirestjs.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.francisco.apirestjs.entidades.Persona;

@RepositoryRestResource(collectionResourceRel = "personas", path = "personas")
public interface PersonasRepositorio extends PagingAndSortingRepository<Persona, Long>{

}
