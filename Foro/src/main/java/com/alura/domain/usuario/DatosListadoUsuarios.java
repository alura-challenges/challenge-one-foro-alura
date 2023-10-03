package com.alura.domain.usuario;

public record DatosListadoUsuarios(Long id, String nombre, String email, String contrasena) {

    public DatosListadoUsuarios(Usuario usuario){
        this(usuario.getId(), usuario.getUsuario(),usuario.getEmail(), usuario.getContrasena());
    }
}
