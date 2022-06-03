package com.salesianostriana.dam.proyectoFinal2.servicios;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.salesianostriana.dam.proyectoFinal2.modelo.Producto;
import com.salesianostriana.dam.proyectoFinal2.repositorios.ProductoRepositorio;

@Service
@Scope (value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CarritoServicio {
	
	private ProductoRepositorio productoRepositorio;
	
	private Map<Producto, Integer> products = new HashMap <> ();
	
	@Autowired
	public CarritoServicio (ProductoRepositorio productoRepositorio) {
		this.productoRepositorio=productoRepositorio;
	}
	
	public void addProduct(Producto p) {
		if(products.containsKey(p)) {
			products.replace(p, products.get(p)+1);
		}else {
			products.put(p,1);
		}
	}
	
	public void removeProduct(Producto p) {
		if(products.containsKey(p)) {
			if(products.get(p)>1) {
				products.replace(p, products.get(p)-1);
			}else if (products.get(p) == 1) {
				products.remove(p);
			}
		}
	}
	
	public Map<Producto, Integer> getProductsInCart() {
        return Collections.unmodifiableMap(products);
    }
}
