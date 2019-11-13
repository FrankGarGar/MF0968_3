package com.francisco.proyectomf0968.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "almacenitems")
public @Data @NoArgsConstructor @AllArgsConstructor class AlmacenItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(cascade=CascadeType.REFRESH)
	private Producto producto;
	@ManyToOne(cascade=CascadeType.REFRESH)
	private Almacen almacen;
	@Min(1)
	private int cantidad;
}
