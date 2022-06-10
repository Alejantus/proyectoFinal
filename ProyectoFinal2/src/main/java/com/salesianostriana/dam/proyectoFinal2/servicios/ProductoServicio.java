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
		// Obtenemos los ids de todos los productos
		List<Long> listaIds = productoRepositorio.obtenerIds();
		// Los desordenamos 
		Collections.shuffle(listaIds);
		// Nos quedamos con los N primeros, con N = numero.
		listaIds = listaIds.stream().limit(numero).collect(Collectors.toList());
		// Buscamos los productos con esos IDs y devolvemos la lista
		return productoRepositorio.findAllById(listaIds);

	}
}