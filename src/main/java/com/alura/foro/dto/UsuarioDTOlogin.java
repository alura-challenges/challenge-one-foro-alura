package com.alura.foro.dto;
 
import jakarta.validation.constraints.NotBlank;

public record UsuarioDTOlogin(
	
		@NotBlank
		String usuario,
		@NotBlank
		String contrasena) {
}
