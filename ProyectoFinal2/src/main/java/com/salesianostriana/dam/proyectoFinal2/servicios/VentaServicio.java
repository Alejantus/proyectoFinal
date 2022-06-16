package com.salesianostriana.dam.proyectoFinal2.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectoFinal2.modelo.Venta;
import com.salesianostriana.dam.proyectoFinal2.repositorios.VentaRepositorio;

@Service
public class VentaServicio extends BaseServicio<Venta, Long, VentaRepositorio>{

	@Autowired
	private VentaRepositorio ventaRepositorio;
	
		public VentaServicio(VentaRepositorio ventaRepositorio) {
		super();
		this.ventaRepositorio = ventaRepositorio;
	}
		
	public Venta add(Venta v) { return ventaRepositorio.save(v); }
	
	public Venta edit(Venta v) { return ventaRepositorio.save(v); }

	public void delete(Venta v) { ventaRepositorio.delete(v); }
	
	public void delete(long id) { ventaRepositorio.deleteById(id); }
	
	public List<Venta> findAll() { return ventaRepositorio.findAll(); }
	
	
	public Venta findById(long id) {
		return ventaRepositorio.findById(id).orElse(null);
	}
    
}
