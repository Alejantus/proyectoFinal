package com.salesianostriana.dam.proyectoFinal2.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.proyectoFinal2.modelo.Producto;
import com.salesianostriana.dam.proyectoFinal2.servicios.CategoriaServicio;
import com.salesianostriana.dam.proyectoFinal2.servicios.ProductoServicio;

@Controller
public class CatalogoControlador {
	
	private static final int NUM_PRODUCTOS_ALEATORIOS = 8;
	
	@Autowired
	private CategoriaServicio categoriaService;
	
	@Autowired
	private ProductoServicio productoService;
	

	
	@GetMapping("/privates/")
	public String index(@RequestParam(name="idCategoria", required=false) Long idCategoria, Model model) {		
		
		model.addAttribute("categorias", categoriaService.findAll());
		
		List<Producto> productos;
		
		if (idCategoria == null) {
			productos = productoService.obtenerProductosAleatorios(NUM_PRODUCTOS_ALEATORIOS);
		} else {			
			productos = productoService.findAllByCategoria(idCategoria);
		}
		
		model.addAttribute("productos", productos);
		
		return "catalogo";
	}
	
	@GetMapping("/privates/producto/{id}")
	public String showDetails(@PathVariable("id") Long id, Model model) {
		
		//Buscamos el producto por id
		Producto p = productoService.findById(id);
		//Si el producto no es null (si existe el producto buscado) se añade al modelo y mostramos la página del detalle detail.html
		//Si no existe, volvemos a la página index que vuelve a realizar todo lo que hace el método index
		if (p != null) {
			model.addAttribute("producto", p);
			return "detalle";
		}
		
		return "redirect:/privates/";
		
	}
}

