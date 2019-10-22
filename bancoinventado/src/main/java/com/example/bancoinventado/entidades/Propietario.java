package com.example.bancoinventado.entidades;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="propietarios")
public @Data @NoArgsConstructor @AllArgsConstructor class Propietario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String apellidos;
	@Column(unique=true)
	private String usuario;
	private String password;
	@Column(name ="last_conexion")
	private LocalDate lastConexion;
}
