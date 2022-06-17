package com.salesianostriana.dam.proyectoFinal2.servicios;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.salesianostriana.dam.proyectoFinal2.modelo.LineaDeVenta;
import com.salesianostriana.dam.proyectoFinal2.modelo.Producto;
import com.salesianostriana.dam.proyectoFinal2.modelo.Venta;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CarritoServicio {

	@Autowired
	private ProductoServicio productoServicio;

	@Autowired
	private VentaServicio ventaServicio;

	@Autowired
	private LineaDeVentaServicio lineaDeVentaServicio;

	private Map<Producto, Integer> products = new HashMap<>();

	public void addProduct(Producto p) {
		if (products.containsKey(p)) {
			products.replace(p, products.get(p) + 1);
		} else {
			products.put(p, 1);
		}
	}

	public void removeProduct(Producto p) {
		if (products.containsKey(p)) {
			if (products.get(p) > 1) {
				products.replace(p, products.get(p) - 1);
			} else if (products.get(p) == 1) {
				products.remove(p);
			}
		}
	}

	public Map<Producto, Integer> getProductsInCart() {
		return Collections.unmodifiableMap(products);
	}

	public void checkout() {
		Venta v = new Venta();
		v.setFecha(LocalDate.now());
		LineaDeVenta lineaDeVenta;
		double total = 0;

		if (!products.isEmpty()) {
			ventaServicio.save(v);
			for (Map.Entry<Producto, Integer> lineaVenta : products.entrySet()) {

				lineaDeVenta = LineaDeVenta.builder().producto(lineaVenta.getKey()).cantidad(lineaVenta.getValue())
						.subtotal(lineaVenta.getKey().getPrecio() * lineaVenta.getValue()).build();

				lineaDeVenta.agregarVenta(v);

				productoServicio.bajarUnidades(lineaVenta.getKey().getId(), lineaVenta.getValue());
				lineaDeVentaServicio.save(lineaDeVenta);

				total += (lineaVenta.getKey().getPrecio() * lineaVenta.getValue());

			}

			v.setTotal(total);

			v.setTotalConIva(precioEspecial(calcularIva(total)));

			ventaServicio.save(v);

			products.clear();

		}

		products.clear();

	}

	public void borrarCarritoCompleto() {
		products.clear();
	}

	public double calcularIva(double total) {

		if(total<=25) {
			total += 5;
		}else if(total<=50) {
			total += 15;
		}else if(total>=100){
			
		}
		return total;
		
	}

	public double precioEspecial(double totalVenta) {

		LocalDate hoy = LocalDate.now();
		LocalDate fechaDescuento = LocalDate.of(2022, 06, 15);
		LocalDate fechaFinalDescuento = LocalDate.of(2022, 06, 30);

		if (hoy.compareTo(fechaDescuento) > 0 && hoy.compareTo(fechaFinalDescuento) < 0)
			totalVenta = totalVenta - ((totalVenta * 10) / 100);

		return totalVenta;
	}
}
