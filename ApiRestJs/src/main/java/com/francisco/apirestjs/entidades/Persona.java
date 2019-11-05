package com.francisco.apirestjs.entidades;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
@Table(name = "personas")

public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(max=30 , min=2)
	private String nombre;
	@NotNull
	@Size(max=50 , min=3)
	private String apellidos;
	@NotNull
	@Size(min=9,max=9)
	@Column(unique=true)
	private String dni;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private Set<Pais> nacionalidades;

}
