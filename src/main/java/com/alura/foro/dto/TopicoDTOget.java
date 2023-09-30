package com.alura.foro.dto;

import java.time.LocalDateTime;

import com.alura.foro.modelo.StatusTopico;
import com.alura.foro.modelo.Topico;

public record TopicoDTOget(
		Long id,
		String titulo,
		String mensaje,
		LocalDateTime fechaCreacion,
		StatusTopico estado,
		Long id_autor,
		String autor,
		Long id_curso,
		String curso
		) {
	
	public TopicoDTOget (Topico topico) {
		this(topico.getId(),
				topico.getTitulo(),
				topico.getMensaje(),
				topico.getFechaCreacion(),
				topico.getEstado(),
				topico.getAutor().getId(),
				topico.getAutor().getNombre(),
				topico.getCurso().getId(),
				topico.getCurso().getNombre());
	}

}
