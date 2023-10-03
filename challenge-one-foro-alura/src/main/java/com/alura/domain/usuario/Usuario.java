package com.alura.domain.usuario;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
public class Usuario implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String usuario;
	private String email;
	private String contrasena;

	public Usuario(String usuario, String email, String contrasena) {
		this.usuario = usuario;
		this.email=email;
		this.contrasena=contrasena;
	}

    public void actualizar(DatosActualizarUsuario datosActualizarUsuario) {
		if(datosActualizarUsuario.nombre()!=null){
			this.usuario = datosActualizarUsuario.nombre();
		}
		if(datosActualizarUsuario.email()!=null){
			this.email= datosActualizarUsuario.email();
		}
		if(datosActualizarUsuario.contrasena()!=null){
			this.contrasena= datosActualizarUsuario.contrasena();
		}
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getPassword() {
		return contrasena;
	}

	@Override
	public String getUsername() {
		return usuario;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
