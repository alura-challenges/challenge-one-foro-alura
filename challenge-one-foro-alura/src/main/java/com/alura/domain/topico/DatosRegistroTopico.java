package com.alura.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico (@NotNull String titulo, @NotNull String mensaje, @NotNull Long autor, @NotNull Long idCurso ){
}
