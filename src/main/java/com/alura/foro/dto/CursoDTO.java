package com.alura.foro.dto;

import jakarta.validation.constraints.NotBlank;

public record CursoDTO(
	
		@NotBlank
		String nombre,

		@NotBlank
		String categoria) {
}
