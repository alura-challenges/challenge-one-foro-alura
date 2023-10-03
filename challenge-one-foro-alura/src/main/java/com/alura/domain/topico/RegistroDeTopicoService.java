package com.alura.domain.topico;

import com.alura.domain.curso.CursoRepository;
import com.alura.domain.usuario.UsuarioRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistroDeTopicoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TopicoRepository repository;

    public Topico registrar(DatosRegistroTopico datosRegistroTopico){
        var curso = cursoRepository.findById(datosRegistroTopico.idCurso()).get();
        var usuario = usuarioRepository.findById(datosRegistroTopico.autor()).get();
        var topico = new Topico(datosRegistroTopico.titulo(),datosRegistroTopico.mensaje(),usuario,curso);
        Topico topicoReturn= repository.save(topico);
        return topico;
    }

    public void validar(Long id){
        if(!repository.findById(id).isPresent()){
            throw new ValidationException("El id del topico no existe");
        }
    }

    public void validarRespuestas(Long id){
        Topico topico = repository.findById(id).get();

        if(topico.getRespuestas().isEmpty()){
            throw new ValidationException("El topico no tiene respuestas aun");
        }
    }

    public void actualizar(DatosActualizarTopico datosActualizarTopico){
        var autor = usuarioRepository.getReferenceById(datosActualizarTopico.autor());
        if(!usuarioRepository.findById(datosActualizarTopico.autor()).isPresent()){
            throw new ValidationException("El id del usuario/autor no existe");
        }
        var curso = cursoRepository.getReferenceById(datosActualizarTopico.idCurso());
        if(!cursoRepository.findById(datosActualizarTopico.idCurso()).isPresent()){
            throw new ValidationException("El id del curso no existe");
        }
        if(!repository.findById(datosActualizarTopico.id()).isPresent()){
            throw new ValidationException("El id del usuario no existe");
        }
        if(repository.existsByMensaje(datosActualizarTopico.mensaje())){
            throw new ValidationException("El mensaje ya se encuentra registrados");
        }
        if(repository.existsByTitulo(datosActualizarTopico.titulo())){
            throw new ValidationException("El titulo ya existe registrado");
        }
        Topico topico = repository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico,autor,curso);
    }
}
