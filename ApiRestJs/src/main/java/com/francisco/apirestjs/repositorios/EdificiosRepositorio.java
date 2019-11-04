package com.francisco.apirestjs.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.francisco.apirestjs.entidades.Edificio;

@RepositoryRestResource(collectionResourceRel = "edificios", path = "edificios")
public interface EdificiosRepositorio extends PagingAndSortingRepository<Edificio, Long>{

}
