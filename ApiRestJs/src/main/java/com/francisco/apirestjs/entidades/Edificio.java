package com.francisco.apirestjs.entidades;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	@Size(min=20,max=20)
	@Column(unique=true)
	private String codigoEdificio;
	@NotNull
	@Min(-90)
	@Max(90)
	//deberia crear un bigdecimal para los grados, 
	//otro para minutos y otro para segundos solo
	//para la altitud o q sea tipo string.
	//Igual para longitud
	private BigDecimal latitud;
	@NotNull
	@Min(-180)
	@Max(180)
	private BigDecimal longitud;
	@NotNull
	private BigDecimal altitud;
	@NotNull
	@OneToOne(cascade = CascadeType.PERSIST)
	private Empresa dueño;
	
}
