package com.example.appspringsecurity.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
	
	private String username;
	@NotNull
	
	private String password;
	@NotNull
	
	private String nombre;
	@NotNull
	
	private String apellidos;
	@NotNull
	
	private Integer edad;
	@NotNull
	private char sexo;
	@NotNull
	
	private String role;
	@NotNull
	private boolean enabled; 
}
