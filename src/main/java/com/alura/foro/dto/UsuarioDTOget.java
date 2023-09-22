package com.alura.foro.dto;

import com.alura.foro.modelo.Usuario;

public record UsuarioDTOget(
		Long id,
		String nombre,
		String email
) {
	
	public UsuarioDTOget (Usuario usuario) {
		this (usuario.getId(),usuario.getNombre(),usuario.getEmail());
	}
	
}
