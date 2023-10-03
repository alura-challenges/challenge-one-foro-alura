package com.alura.domain.respuesta;

import com.alura.domain.topico.Topico;
import com.alura.domain.usuario.Usuario;
import com.alura.domain.usuario.UsuarioRepository;
import com.alura.domain.topico.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistroRespuestaService {
    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void validar(Long idUsuario, Long idTopico){
        if(!usuarioRepository.findById(idUsuario).isPresent()){
            throw new ValidationException("El Id del usuario proporcionado no existe");
        }
        if(!topicoRepository.findById(idTopico).isPresent()){
            throw new ValidationException("El id del topico proporcionado no existe");
        }
    }

    public void validarExistencia(Long id){
        if(!respuestaRepository.findById(id).isPresent()){
            throw new ValidationException("El id de la respuesta no existe");
        }
    }

    public Respuesta registrar(DatosRespuesta datos){
        this.validar(datos.usuarioId(), datos.topicoId());
        Usuario usuario = usuarioRepository.getReferenceById(datos.usuarioId());
        Topico topico = topicoRepository.getReferenceById(datos.topicoId());
        Respuesta respuesta = new Respuesta(datos.mensaje(),usuario,topico);
        return respuestaRepository.save(respuesta);
    }

    public void actualizar(DatosActualizarRespuesta datosActualizarRespuesta) {
        this.validar(datosActualizarRespuesta.idUsuario(), datosActualizarRespuesta.idTopico());
        this.validarExistencia(datosActualizarRespuesta.id());
        Respuesta respuesta = respuestaRepository.getReferenceById(datosActualizarRespuesta.id());
        Usuario usuario = usuarioRepository.getReferenceById(datosActualizarRespuesta.idUsuario());
        Topico topico = topicoRepository.getReferenceById(datosActualizarRespuesta.idTopico());

        respuesta.actualizar(datosActualizarRespuesta, usuario, topico);
    }
}
