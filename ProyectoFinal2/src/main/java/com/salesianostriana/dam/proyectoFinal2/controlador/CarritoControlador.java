package com.salesianostriana.dam.proyectoFinal2.controlador;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.proyectoFinal2.servicios.CarritoServicio;
import com.salesianostriana.dam.proyectoFinal2.servicios.ProductoServicio;
import com.salesianostriana.dam.proyectoFinal2.modelo.Producto;

@Controller
public class CarritoControlador {

	@Autowired
	private CarritoServicio carritoServicio;

	@Autowired
	private ProductoServicio productoServicio;

	@Autowired
	public CarritoControlador(CarritoServicio carritoServicio, ProductoServicio productoServicio) {
		this.carritoServicio = carritoServicio;
		this.productoServicio = productoServicio;
	}

	@GetMapping("/private/carrito")
	public String showCarrito(Model model) {

		if (model.addAttribute("productos", carritoServicio.getProductsInCart()) == null)
			return "redirect:/privates/";
		return "private/carrito";
	}

	@GetMapping("/productoACarrito/{id}")
	public String productoACarrito(@PathVariable("id") Long id, Model model) {

		carritoServicio.addProduct(productoServicio.findById(id));

		return "redirect:/private/carrito";
	}

	@GetMapping("/borrarProducto/{id}")
	public String removeProductFromCart(@PathVariable("id") Long id) {

		carritoServicio.removeProduct(productoServicio.findById(id));
		return "redirect:/private/carrito";
	}

	@ModelAttribute("totalCarrito")
	public Double totalCarrito() {

		Map<Producto, Integer> carrito = carritoServicio.getProductsInCart();
		double total = 0.0;
		if (carrito != null) {
			for (Producto p : carrito.keySet()) {
				total += p.getPrecio() * p.getUnidades();
			}
			return total;
		}
		return 0.0;
	}
	
	@ModelAttribute("totalCarritoIva")
	public double totalCarritoIva() {
		return carritoServicio.calcularIva(carritoServicio.precioEspecial(totalCarrito()));
	}
	
	@PostMapping("/checkout")
    public String checkout(){
    	  	carritoServicio.checkout();
    return "redirect:/private/catalogo";
    }

}
