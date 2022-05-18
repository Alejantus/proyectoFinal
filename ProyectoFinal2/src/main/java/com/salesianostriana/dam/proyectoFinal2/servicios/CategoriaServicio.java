package com.salesianostriana.dam.proyectoFinal2.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectoFinal2.modelo.Categoria;
import com.salesianostriana.dam.proyectoFinal2.repositorios.CategoriaRepositorio;

@Service
public class CategoriaServicio {
	
	@Autowired
	private CategoriaRepositorio repositorio;
	
	public List<Categoria> findAll() {
		return repositorio.findAll();
	}	
	
	public Categoria save(Categoria categoria) {
		return repositorio.save(categoria);
	}
	
	public Categoria findById(Long id) {
		return repositorio.findById(id).orElse(null);
	}
	
	public Categoria delete(Categoria categoria) {
		Categoria result = findById(categoria.getId());
		repositorio.delete(result);
		return result;
	}

}