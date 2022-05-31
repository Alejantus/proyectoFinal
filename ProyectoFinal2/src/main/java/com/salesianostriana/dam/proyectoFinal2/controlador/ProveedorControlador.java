package com.salesianostriana.dam.proyectoFinal2.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.proyectoFinal2.modelo.Proveedor;
import com.salesianostriana.dam.proyectoFinal2.servicios.ProductoServicio;
import com.salesianostriana.dam.proyectoFinal2.servicios.ProveedorServicio;

@Controller
public class ProveedorControlador {
	
	@Autowired
	private ProveedorServicio proveedorService;
	
	@Autowired
	private ProductoServicio productoService;
	
		
	@GetMapping("/admin/tablaProveedor")
	public String index(Model model) {
		model.addAttribute("proveedor", proveedorService.findAll());
		return "admin/tabla_proveedor";
	}

	@GetMapping("/admin/formularioProveedor")
	public String nuevaProducto(Model model) {
		
		model.addAttribute("proveedor", new Proveedor());
		return "admin/formulario_proveedor";
	}

	@PostMapping("/admin/formularioProveedor/submit")
	public String submitNuevoProducto(Proveedor proveedor, Model model) {

		proveedorService.save(proveedor);
		return "redirect:/admin/tablaProveedor";

	}
	
	@GetMapping("/tablaProveedor/editar/{id}")
	public String editarProducto(@PathVariable("id") Long id, Model model) {

		Proveedor proveedor = proveedorService.findById(id);

		if (proveedor != null) {
			model.addAttribute("proveedor", proveedor);
			return "admin/formulario_proveedor";
		} else {
			return "redirect:/tablaProveedor";
		}

	}
	
	
	@GetMapping("/tablaProveedor/borrar/{id}")
	public String borrarProducto(@PathVariable("id") Long id, Model model) {

		Proveedor proveedor = proveedorService.findById(id);

		if (productoService.numeroProductosCategoria(proveedor) == 0) {
			proveedorService.delete(proveedor);
		}else {
			return "redirect:/tablaProveedor/?error=true";
		}

		return "redirect:/tablaProveedor";

	}
}

