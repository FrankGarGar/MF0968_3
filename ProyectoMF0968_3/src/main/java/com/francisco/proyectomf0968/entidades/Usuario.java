package com.francisco.proyectomf0968.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="usuarios")
public @Data @NoArgsConstructor @AllArgsConstructor class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min = 4 , max = 15)
	private String username;
	@NotNull
	@Size(min = 4 , max = 255)
	private String password;
	@NotNull
	@Size(min = 2 , max = 25)
	private String nombre;
	@NotNull
	@Size(min = 2 , max = 25)
	private String apellidos;
	@NotNull
	@Min(18)
	private Integer edad;
	@NotNull
	private String sexo;
	@Size(min = 4 , max = 10)
	private String role;
	@NotNull
	private boolean enabled; 
}
