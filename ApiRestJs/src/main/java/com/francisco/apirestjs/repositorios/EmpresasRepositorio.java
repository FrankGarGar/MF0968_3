package com.francisco.apirestjs.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.francisco.apirestjs.entidades.Empresa;

@RepositoryRestResource(collectionResourceRel = "empresas", path = "empresas")
public interface EmpresasRepositorio extends PagingAndSortingRepository<Empresa, Long>{

}
