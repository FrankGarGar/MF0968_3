package com.francisco.apirestjs.entidades;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
@Table(name = "empresas")
public class Empresa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(max=80 , min=5)
	private String nombre;
	@NotNull
	@Size(min=20,max=20)
	private String codigoEmpresa;
	@NotNull
	@OneToOne
	private Persona presidenteActual;
	@OneToMany
	private Set<Edificio> sedes;
}
