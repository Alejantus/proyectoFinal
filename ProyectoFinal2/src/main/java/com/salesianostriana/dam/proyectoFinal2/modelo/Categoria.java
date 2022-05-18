package com.salesianostriana.dam.proyectoFinal2.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Builder
public class Categoria {

	@Id
	@GeneratedValue
	private long id;
	private String nombre;
	private boolean destacada;
	private String imagen;
}