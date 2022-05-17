package com.salesianostriana.dam.proyectoFinal2.modelo;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data @Entity @NoArgsConstructor @AllArgsConstructor
public class Prueba {

	private String nombre;
}
