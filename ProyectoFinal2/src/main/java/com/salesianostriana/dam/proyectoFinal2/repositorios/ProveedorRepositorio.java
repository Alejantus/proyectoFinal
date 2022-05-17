package com.salesianostriana.dam.proyectoFinal2.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.proyectoFinal2.modelo.Proveedor;

@Repository
public interface ProveedorRepositorio extends JpaRepository<Proveedor, Long> {

	@Query("select p.idProveedor from Proveedor p")
	public List<Long> obtenerIds();
}
