package com.alura.foro.dto;

import jakarta.validation.constraints.NotNull;

public record TopicoDTOupdate(
		@NotNull
		Long id,
		String titulo,
		String mensaje,
		@NotNull
		Long id_autor,
		Long id_curso
		) {

}
