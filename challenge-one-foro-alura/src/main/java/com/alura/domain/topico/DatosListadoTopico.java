package com.alura.domain.topico;

public record DatosListadoTopico(Long id, String titulo, String mensaje, Long autor, Long idCurso ) {
    public DatosListadoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(),topico.getMensaje(),topico.getAutor().getId(),topico.getCurso().getId());
    }
}
