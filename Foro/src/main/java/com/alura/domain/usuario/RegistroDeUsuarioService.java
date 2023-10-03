package com.alura.domain.usuario;

import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistroDeUsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public void actualizar(DatosActualizarUsuario datosActualizarUsuario){
        this.validarExistencia(datosActualizarUsuario.id());

        Usuario usuario = usuarioRepository.getReferenceById(datosActualizarUsuario.id());
        usuario.actualizar(datosActualizarUsuario);
    }

    public void validarExistencia(Long id){
        if(!usuarioRepository.findById(id).isPresent()){
            throw new ValidationException("El id del usuario proporcionado no existe");
        }
    }
}
