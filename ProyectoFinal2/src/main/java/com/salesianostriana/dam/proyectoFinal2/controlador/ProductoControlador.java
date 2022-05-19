package com.salesianostriana.dam.proyectoFinal2.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.proyectoFinal2.modelo.Producto;
import com.salesianostriana.dam.proyectoFinal2.servicios.CategoriaServicio;
import com.salesianostriana.dam.proyectoFinal2.servicios.ProductoServicio;
import com.salesianostriana.dam.proyectoFinal2.servicios.ProveedorServicio;

@Controller
public class ProductoControlador {
	
	@Autowired
	private ProductoServicio productoService;
	
	@Autowired
	private CategoriaServicio categoriaService;
	
	@Autowired
	private ProveedorServicio proveedorServicio;

	@GetMapping("/tablaProducto")
	public String index(Model model) {
		model.addAttribute("productos", productoService.findAll());
		return "admin/tabla_producto";
	}

	@GetMapping("/formularioProducto")
	public String nuevaProducto(Model model) {
		
		model.addAttribute("producto", new Producto());
		model.addAttribute("categorias", categoriaService.findAll());
		model.addAttribute("proveedor",proveedorServicio.findAll());
		return "admin/formulario_producto";
	}

	@PostMapping("/formularioProducto/submit")
	public String submitNuevoProducto(Producto producto, Model model) {

		productoService.save(producto);
		return "redirect:/admin/tablaProducto";

	}
	
	@GetMapping("/editar/{id}")
	public String editarProducto(@PathVariable("id") Long id, Model model) {

		Producto producto = productoService.findById(id);

		if (producto != null) {
			model.addAttribute("producto", producto);
			model.addAttribute("categorias", categoriaService.findAll());
			model.addAttribute("proveedor",proveedorServicio.findAll());
			return "admin/formulario_producto";
		} else {
			return "redirect:/admin/tablaProducto";
		}

	}
	
	
	@GetMapping("/borrar/{id}")
	public String borrarProducto(@PathVariable("id") Long id, Model model) {

		Producto producto = productoService.findById(id);

		if (producto != null) {
			productoService.delete(producto);
		}

		return "redirect:/admin/tablaProducto";

	}

}
