package com.alura.foro.modelo;

import java.util.Objects;

import com.alura.foro.dto.UsuarioDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity (name = "Usuario")
@Table (name ="Usuarios")
@Getter
@NoArgsConstructor
public class Usuario {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String email;
	private String contrasena;
	
	public Usuario(Long id, String nombre, String email, String contrasena) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.contrasena = contrasena;
	}

	public Usuario(UsuarioDTO usuarioDTO) {
		this.nombre=usuarioDTO.nombre();
		this.email=usuarioDTO.email();
		this.contrasena=usuarioDTO.contrasena();
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;}
		
		if (obj == null) {
			return false;}
		
		if (getClass() != obj.getClass()) {
			return false;}
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
