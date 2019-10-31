package com.example.appspringsecurity.entidades;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="productos")
public @Data @NoArgsConstructor @AllArgsConstructor class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min = 3, max = 45)
	private String nombre;
	@NotNull
	@Size(min = 12  , max = 12)
	private String codigo;
	@NotNull
	@ManyToOne
	private Categoria categoria;
	@NotNull
	@Min(value = 0)
	private BigDecimal precio;
	@NotNull
	
	private Integer stock;
	
}
