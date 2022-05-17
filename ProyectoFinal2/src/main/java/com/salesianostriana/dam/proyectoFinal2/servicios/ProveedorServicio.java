package com.salesianostriana.dam.proyectoFinal2.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectoFinal2.modelo.Proveedor;
import com.salesianostriana.dam.proyectoFinal2.repositorios.ProveedorRepositorio;

@Service
public class ProveedorServicio {
	
	@Autowired
	private ProveedorRepositorio proveedorRepositorio;
	
	public List<Proveedor> findAll() {
		return proveedorRepositorio.findAll();
	}	
	
	public Proveedor save(Proveedor Proveedor) {
		return proveedorRepositorio.save(Proveedor);
	}
	
	public Proveedor findById(Long id) {
		return proveedorRepositorio.findById(id).orElse(null);
	}
	
	public Proveedor delete(Proveedor Proveedor) {
		Proveedor result = findById(Proveedor.getIdProveedor());
		proveedorRepositorio.delete(result);
		return result;
	}
}