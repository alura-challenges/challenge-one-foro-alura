package com.alura.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosRegistroUsuario(@NotBlank String nombre, @NotBlank @Email String email,@NotBlank String contrasena) {
}
