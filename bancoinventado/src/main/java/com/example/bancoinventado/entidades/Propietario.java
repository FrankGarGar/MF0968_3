package com.example.bancoinventado.entidades;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="propietarios")
public @Data @NoArgsConstructor @AllArgsConstructor class Propietario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String nombre;
	@NotNull
	private String apellidos;
	@Column(unique=true)
	private String usuario;
	private String password;
	@NotNull
	@Column(name ="last_conexion")
	private LocalDate lastConexion;
	private String Role;
}
