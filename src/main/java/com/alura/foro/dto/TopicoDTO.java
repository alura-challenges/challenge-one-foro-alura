package com.alura.foro.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicoDTO(
		@NotBlank
		String titulo,
		@NotBlank
		String mensaje,
		@NotNull
		Long id_autor,
		@NotNull
		Long id_curso
		) {

}
