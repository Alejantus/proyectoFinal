package com.salesianostriana.dam.proyectoFinal2.servicios;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectoFinal2.modelo.Categoria;
import com.salesianostriana.dam.proyectoFinal2.modelo.Producto;
import com.salesianostriana.dam.proyectoFinal2.modelo.Proveedor;
import com.salesianostriana.dam.proyectoFinal2.repositorios.ProductoRepositorio;

@Service
public class ProductoServicio {

	@Autowired
	private ProductoRepositorio productoRepositorio;
	
	public List<Producto> findAll() {
		return productoRepositorio.findAll();
	}
	
	public List<Producto> findAllByCategoria(Categoria categoria) {
		return productoRepositorio.findByCategoria(categoria);
	}
	
	public List<Producto> findAllByCategoria(Long categoriaId) {
		return productoRepositorio.findByCategoriaId(categoriaId);
	}
	
	public List<Producto> findByNombre(String nombre){
		return productoRepositorio.findByNombreContainingIgnoreCase(nombre);
	}
	
	public Producto findById(Long id) {
		return productoRepositorio.findById(id).orElse(null);
	}
	
	public Producto save(Producto producto) {
		return productoRepositorio.save(producto);
	}
	
	public Producto edit(Producto p) {
		return productoRepositorio.save(p);
	}
	
	public Producto delete(Producto producto) {
		Producto result = findById(producto.getId());
		productoRepositorio.delete(result);
		return result;
	}
	
	public void delete(long id) { productoRepositorio.deleteById(id); }
	
	public int numeroProductosCategoria(Categoria categoria) {
		return productoRepositorio.findNumProductosByCategoria(categoria);
	}
	
	public int numeroProductosCategoria(Proveedor proveedor) {
		return productoRepositorio.findNumProductosByProveedor(proveedor);
	}
	
	public List<Producto> obtenerProductosAleatorios(int numero) {
		List<Long> listaIds = productoRepositorio.obtenerIds();
		Collections.shuffle(listaIds);
		listaIds = listaIds.stream().limit(numero).collect(Collectors.toList());
		return productoRepositorio.findAllById(listaIds);
	}
	
	public Producto bajarUnidades(long id , int unidades) {
		Producto p = findById(id);
		p.setUnidades(p.getUnidades()-unidades);
		return (p);
	}
}