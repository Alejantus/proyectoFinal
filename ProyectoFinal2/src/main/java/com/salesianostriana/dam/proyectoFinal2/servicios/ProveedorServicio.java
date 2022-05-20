package com.salesianostriana.dam.proyectoFinal2.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectoFinal2.modelo.Proveedor;
import com.salesianostriana.dam.proyectoFinal2.repositorios.ProveedorRepositorio;

@Service
public class ProveedorServicio {
	
	@Autowired
	private ProveedorRepositorio repositorio;
	
	public List<Proveedor> findAll() {
		return repositorio.findAll();
	}	
	
	public Proveedor save(Proveedor Proveedor) {
		return repositorio.save(Proveedor);
	}
	
	public Proveedor findById(Long id) {
		return repositorio.findById(id).orElse(null);
	}
	
	public Proveedor delete(Proveedor Proveedor) {
		Proveedor result = findById(Proveedor.getId());
		repositorio.delete(result);
		return result;
	}
}