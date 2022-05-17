package com.salesianostriana.dam.proyectoFinal2.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyectoFinal2.modelo.Proveedor;
import com.salesianostriana.dam.proyectoFinal2.servicios.ProductoServicio;
import com.salesianostriana.dam.proyectoFinal2.servicios.ProveedorServicio;

@Controller
@RequestMapping("/admin")
public class ProveedorControlador {
	
	@Autowired
	private ProveedorServicio proveedorServicio;
	
	@Autowired
	private ProductoServicio productoServicio;
	
		
	@GetMapping("/tablaProveedor")
	public String index(Model model) {
		model.addAttribute("productos", proveedorServicio.findAll());
		return "admin/tabla_proveedor";
	}

	@GetMapping("/formularioProveedor")
	public String nuevaProducto(Model model) {
		
		model.addAttribute("proveedor", new Proveedor());
		return "admin/formulario_proveedor";
	}

	@PostMapping("/formularioProveedor/submit")
	public String submitNuevoProducto(Proveedor proveedor, Model model) {

		proveedorServicio.save(proveedor);
		return "redirect:/admin/tablaProveedor";

	}
	
	@GetMapping("/formularioProveedor/editar/{id}")
	public String editarProducto(@PathVariable("id") Long id, Model model) {

		Proveedor proveedor = proveedorServicio.findById(id);

		if (proveedor != null) {
			model.addAttribute("proveedor", proveedor);
			return "admin/formulario_producto";
		} else {
			return "redirect:/admin/tablaProveedor";
		}

	}
	
	
	@GetMapping("/tablaProveedor/borrar/{id}")
	public String borrarProducto(@PathVariable("id") Long id, Model model) {

		Proveedor proveedor = proveedorServicio.findById(id);

		if (productoServicio.numeroProductosCategoria(proveedor) == 0) {
			proveedorServicio.delete(proveedor);
		}else {
			return "redirect:/admin/tablaProveedor/?error=true";
		}

		return "redirect:/admin/tablaProducto";

	}
}

