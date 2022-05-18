package com.salesianostriana.dam.proyectoFinal2.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyectoFinal2.modelo.Categoria;
import com.salesianostriana.dam.proyectoFinal2.servicios.CategoriaServicio;
import com.salesianostriana.dam.proyectoFinal2.servicios.ProductoServicio;

@Controller
public class CategoriaControlador {

	@Autowired
	private CategoriaServicio categoriaService;
	
	@Autowired
	private ProductoServicio productoService;
	
	@GetMapping("/tablaCategoria")
	public String index(Model model) {		
		model.addAttribute("categorias", categoriaService.findAll());
		return "admin/tabla_categoria";
	}
	
	@GetMapping("/formularioCategoria")
	public String nuevaCategoria(Model model) {
		model.addAttribute("categoria", new Categoria());
		return "admin/formulario_categoria";
	}
	
	@PostMapping("/formularioCategoria/submit")
	public String submitNuevaCategoria(@ModelAttribute("categoria") Categoria categoria, Model model) {
		
		categoriaService.save(categoria);
		return "redirect:/admin/tablaCategoria";
	}
	
	@GetMapping("/editar/{id}")
	public String editarCategoria(@PathVariable("id") Long id, Model model) {
		
		Categoria categoria = categoriaService.findById(id);
		
		if (categoria != null) {
			model.addAttribute("categoria", categoria);
			return "admin/form-categoria";
		} else {
			return "redirect:/admin/categoria/";
		}
		
	}

	@GetMapping("/borrar/{id}")
	public String borrarCategoria(@PathVariable("id") Long id, Model model) {
		
		Categoria categoria = categoriaService.findById(id);
		
		if (categoria != null) {
			
			if (productoService.numeroProductosCategoria(categoria) == 0) {
				categoriaService.delete(categoria);				
			} else {
				
			//Se ha agregado el parámetro error con valor true a la ruta	
				return "redirect:admin/tablaCategoria/?error=true";
			}
			
		} 

		return "redirect:/admin/tablaCategoria";
		
		
	}
}

