package com.alura.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarUsuario(@NotNull Long id,
                                     String nombre,
                                     @Email String email,
                                     String contrasena) {
}
