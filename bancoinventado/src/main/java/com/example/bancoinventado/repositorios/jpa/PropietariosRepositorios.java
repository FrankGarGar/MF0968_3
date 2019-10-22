package com.example.bancoinventado.repositorios.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.bancoinventado.entidades.Propietario;

public interface PropietariosRepositorios extends CrudRepository<Propietario, Long>{
	List<Propietario> findByNombre(String nombre);
	List<Propietario> findByApellidos(String apellidos);
}
