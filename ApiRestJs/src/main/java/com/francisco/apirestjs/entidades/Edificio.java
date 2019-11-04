package com.francisco.apirestjs.entidades;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity 
@Data
@Table(name = "edificios")
public class Edificio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(max=50 , min=5)
	private String nombre;
	@NotNull
	private String codigoEdificio;
	@Min(-90)
	@Max(90)
	private BigDecimal latitud;
	@Min(-180)
	@Max(180)
	private BigDecimal longitud;
	@NotNull
	@OneToOne
	private Empresa dueño;
	
}
