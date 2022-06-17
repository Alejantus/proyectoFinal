package com.salesianostriana.dam.proyectoFinal2.modelo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class LineaDeVenta {

	@OneToOne
	private Producto producto;
	
	@Id
	@GeneratedValue
	private long id;
	
	private int cantidad;
	
	private double subtotal;
	
	@ManyToOne
	private Venta venta;
	
	public void agregarVenta(Venta venta) {
		this.venta = venta;
		venta.getListaDeVenta().add(this);
	}
	
	public void borrarVenta(Venta venta) {
		venta.getListaDeVenta().remove(this);
		this.venta = null;
	}
	
	
}
