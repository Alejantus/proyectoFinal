package com.salesianostriana.dam.proyectoFinal2.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.proyectoFinal2.formbeans.SearchBean;
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
	

	
	
	@GetMapping("/private/catalogo")
	public String index(@RequestParam(name="idCategoria", required=false) Long idCategoria, Model model) {		
		
		model.addAttribute("categorias", categoriaService.findAll());
		
		List<Producto> productos;
		
		if (idCategoria == null) {
			productos = productoService.obtenerProductosAleatorios(NUM_PRODUCTOS_ALEATORIOS);
		} else {			
			productos = productoService.findAllByCategoria(idCategoria);
		}
		
		model.addAttribute("productos", productos);
		model.addAttribute("searchForm",new SearchBean());
		
		return "private/catalogo";
	}
	
	@PostMapping("/private/search")
	public String buscarProducto(@ModelAttribute("searchForm") SearchBean searchBean,Model model) {
		model.addAttribute("productos",productoService.findByNombre(searchBean.getSearch()));
		return "private/catalogo";
	}
	
	@GetMapping("/private/producto/{id}")
	public String showDetails(@PathVariable("id") Long id, Model model) {
		
		Producto p = productoService.findById(id);
		
		if (p != null) {
			model.addAttribute("producto", p);
			return "private/detalle";
		}
		
		return "redirect:/private/catalogo";
		
	}
}

