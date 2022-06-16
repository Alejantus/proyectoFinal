package com.salesianostriana.dam.proyectoFinal2.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.proyectoFinal2.modelo.LineaDeVenta;

@Repository
public interface LineaDeVentaRepositorio extends JpaRepository<LineaDeVenta, Long>{

}
