package com.salesianostriana.dam.proyectoFinal2.seguridad;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {

	private String username, password, role;
	private String nombre;
	//private String avatar;
	
	public String getAvatar() {
		return "https://robohash.org/"+username;
	}
}
