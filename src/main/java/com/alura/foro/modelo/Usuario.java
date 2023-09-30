package com.alura.foro.modelo;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
public class Usuario implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		//return null;
		return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.contrasena;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.nombre;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
