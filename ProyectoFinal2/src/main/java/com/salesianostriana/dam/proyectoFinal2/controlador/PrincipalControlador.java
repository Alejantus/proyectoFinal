package com.salesianostriana.dam.proyectoFinal2.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.proyectoFinal2.servicios.ProductoServicio;

public class PrincipalControlador {
	
	@Autowired
	private ProductoServicio productoService;

	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("productos", productoService.findAll());
		return "index";
	}

}
