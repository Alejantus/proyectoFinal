package com.salesianostriana.dam.proyectoFinal2.seguridad;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepo {
	
	private List<Usuario> usuarios;

	public List<Usuario> getUsuarios() {
		return Collections.unmodifiableList(usuarios);
	}

	public Optional<Usuario> findUserByUsername(String username) {
		return usuarios.stream()
				.filter(u -> u.getUsername().equals(username))
				.findFirst();
	}
	
	@PostConstruct
	public void init() {
		usuarios = List.of(
				Usuario.builder()
					.username("admin")
					.password("admin")
					.role("ADMIN")
					.nombre("Administrador")
					.build()
				,
				Usuario.builder()
				.username("usuario")
				.password("1234")
				.role("USER")
				.nombre("Usuario")				
				.build()
				
				
				);
				
	}
	
	

}
