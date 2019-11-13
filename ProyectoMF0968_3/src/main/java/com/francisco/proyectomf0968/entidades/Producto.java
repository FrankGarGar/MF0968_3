package com.francisco.proyectomf0968.entidades;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	private String Imagen;
	@Size(min= 50, max=300)
	private String descripcion;
	@NotNull
	@Min(value = 0)
	private BigDecimal precio;
	@OneToMany
	private Set<AlmacenItem> almacenItems;
}
