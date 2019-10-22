package com.example.bancoinventado.repositorios;

import com.example.bancoinventado.entidades.Propietario;

public interface PropietarioDao extends Dao<Propietario, Long>{
	Iterable<Propietario> findByNombre();
	Iterable<Propietario> findByApellidos();
}
