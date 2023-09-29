package com.alura.foro.dto;

import com.alura.foro.modelo.Curso;

public record CursoDTOget(
		Long id,
		String nombre,
		String categoria) {
	
	public CursoDTOget(Curso curso) {
		this(curso.getId(),
			 curso.getNombre(),
			 curso.getCategoria());
	}
	
}
