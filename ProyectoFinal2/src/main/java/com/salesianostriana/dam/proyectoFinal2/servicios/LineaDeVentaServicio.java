package com.salesianostriana.dam.proyectoFinal2.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectoFinal2.modelo.LineaDeVenta;
import com.salesianostriana.dam.proyectoFinal2.modelo.Venta;
import com.salesianostriana.dam.proyectoFinal2.repositorios.LineaDeVentaRepositorio;

@Service
public class LineaDeVentaServicio extends BaseServicio<LineaDeVenta, Long, LineaDeVentaRepositorio> {

	@Autowired
	private LineaDeVentaRepositorio lineaVentaRepositorio;

	@Autowired
	private CarritoServicio carritoServicio;
	
	@Autowired
	private VentaServicio ventaServicio;

	public List<LineaDeVenta> findAll() {
		return lineaVentaRepositorio.findAll();
	}

	public LineaDeVenta edit(LineaDeVenta lv) {
		return lineaVentaRepositorio.save(lv);
	}

	public LineaDeVenta borrarUnaUdProductoDeLineaVenta(long id) {
		LineaDeVenta lineaDeVenta = findById(id);
		lineaDeVenta.setCantidad(lineaDeVenta.getCantidad() - 1);
		Venta v = lineaDeVenta.getVenta();
		v.setTotal(lineaDeVenta.getVenta().getTotal() - lineaDeVenta.getProducto().getPrecio());
		v.setTotalConIva(carritoServicio.precioEspecial(carritoServicio.calcularIva(v.getTotal())));
		ventaServicio.edit(v);
		return edit(lineaDeVenta);
	}

}