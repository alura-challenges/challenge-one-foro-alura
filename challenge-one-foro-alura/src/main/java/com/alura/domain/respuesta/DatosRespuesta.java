package com.alura.domain.respuesta;

import jakarta.validation.constraints.NotNull;

public record DatosRespuesta(@NotNull String mensaje,
                             @NotNull Long topicoId,
                             @NotNull Long usuarioId) {
}
