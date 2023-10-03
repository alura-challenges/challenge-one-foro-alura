package com.alura.domain.respuesta;

import java.time.LocalDateTime;

public record DatosListadoRespuestas(Long id, String mensaje, Long topicoId, LocalDateTime fechaCreacion, Long usuarioId, Boolean solucion) {
    public DatosListadoRespuestas(Respuesta respuesta){
        this(respuesta.getId(), respuesta.getMensaje(),respuesta.getTopico().getId(),
                respuesta.getfechaCreacion(),respuesta.getAutor().getId(),respuesta.getSolucion());
    }
}
