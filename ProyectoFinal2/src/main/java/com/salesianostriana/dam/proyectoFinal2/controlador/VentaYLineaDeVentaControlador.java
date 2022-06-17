package com.salesianostriana.dam.proyectoFinal2.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.proyectoFinal2.modelo.LineaDeVenta;
import com.salesianostriana.dam.proyectoFinal2.servicios.LineaDeVentaServicio;
import com.salesianostriana.dam.proyectoFinal2.servicios.ProductoServicio;
import com.salesianostriana.dam.proyectoFinal2.servicios.VentaServicio;

@Controller
public class VentaYLineaDeVentaControlador {
	
	@Autowired
	ProductoServicio productoServicio;
	
	@Autowired
	LineaDeVentaServicio lineaDeVentaServicio;
	
	@Autowired
	VentaServicio ventaServicio;
	
	@GetMapping("private/historialVentas")
	public String mostrarVentas(Model model) {
		model.addAttribute("ventas",ventaServicio.findAll());
		return "private/ventas";
	}	
	
	
	@GetMapping("/private/borrarVenta/{id}")
	public String borrarVenta(@PathVariable("id") Long id, Model model) {
		ventaServicio.deleteById(id);
		return "redirect:/private/historialVentas";
	}
	
	@GetMapping("/private/historialVentas/detallesVenta/{id}")
	public String listarLineasUnaVenta(@PathVariable("id") Long id ,Model model) {
		model.addAttribute("lineasDeVenta",ventaServicio.findById(id).getListaDeVenta());
		return "detalleVenta";
	}
	
	@GetMapping("/private/borrarLineaVenta/{id}")
	public String borrarLineaVenta(@PathVariable("id") Long id, Model model) {
		LineaDeVenta lineaDeVenta = lineaDeVentaServicio.findById(id);
		long id_venta = lineaDeVenta.getVenta().getId();
		lineaDeVentaServicio.borrarUnaUnidadProductoDeLineaVenta(id);
		if(lineaDeVenta.getCantidad()==0){
			lineaDeVentaServicio.delete(lineaDeVenta);
			}
		return "redirect:/private/historialVentas/detalleVenta/" + id_venta;
	}
	
}
