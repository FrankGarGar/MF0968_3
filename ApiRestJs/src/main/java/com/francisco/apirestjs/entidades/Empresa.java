package com.francisco.apirestjs.entidades;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	@Column(unique=true)
	private String codigoEmpresa;
	@NotNull
	@OneToOne(cascade = CascadeType.PERSIST)
	private Persona presidenteActual;
	@OneToMany(cascade = CascadeType.PERSIST)
	private Set<Edificio> sedes;
}
