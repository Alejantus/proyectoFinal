package com.salesianostriana.dam.proyectoFinal2.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Producto {

	@Id
	@GeneratedValue
	private long id;
	private String nombre;
	private double precio;
	private double descuento;
	private String imagen;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaCaducidad;
	
	private String descripcion;
	private boolean disponible;
	@ManyToOne
	private Categoria categoria;
	@ManyToOne
	private Proveedor proveedor;
}
