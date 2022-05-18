package com.salesianostriana.dam.proyectoFinal2.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data @Entity @NoArgsConstructor @AllArgsConstructor
@Builder
public class Proveedor {
	
	@Id
	@GeneratedValue
	private long idProveedor;
	private String nombre;
	private int telefono;
	private String direccion;
	private String email;
	private int codigoPostal;
	

}