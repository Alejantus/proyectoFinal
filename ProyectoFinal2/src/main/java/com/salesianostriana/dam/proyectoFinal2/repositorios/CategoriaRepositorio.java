package com.salesianostriana.dam.proyectoFinal2.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.proyectoFinal2.modelo.Categoria;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {
	
	public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
		
		
		@Query("select c from Categoria c where c.destacada = true")
		public List<Categoria> findDestacadas();		

	}


}
