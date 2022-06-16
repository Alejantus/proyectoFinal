package com.salesianostriana.dam.proyectoFinal2.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepositorio {
	
	@Query("select v.id from Venta v")
	public List<Long> obtenerIds();

}
