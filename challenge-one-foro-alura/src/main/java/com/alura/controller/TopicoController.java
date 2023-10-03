package com.alura.controller;

import com.alura.domain.respuesta.DatosListadoRespuestas;
import com.alura.domain.respuesta.Respuesta;
import com.alura.domain.topico.*;

import com.alura.domain.topico.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private RegistroDeTopicoService service;


    @PostMapping
    @Transactional
    public ResponseEntity registraTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
                                         UriComponentsBuilder uriComponentsBuilder){
        Topico topico = service.registrar(datosRegistroTopico);
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRegistroTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listaTopicos(@PageableDefault(size = 5,sort = "id")Pageable paginacion){
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosListadoTopico::new));
    }

    @GetMapping("/respuestas/{id}")
    public ResponseEntity<List<DatosListadoRespuestas>> listaRespuestasTopico(@PageableDefault(size = 5,sort = "id")Pageable paginacion,
                                                                 @PathVariable Long id){
        service.validar(id);

        Topico topico = topicoRepository.findById(id).get();

        service.validarRespuestas(id);

        List<Respuesta> listaRespuestas = topico.getRespuestas();

        return ResponseEntity.ok(listaRespuestas.stream().map(DatosListadoRespuestas::new).collect(Collectors.toList()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        service.validar(id);
        topicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){

        service.actualizar(datosActualizarTopico);
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        return  ResponseEntity.ok(new DatosRespuestaTopico(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getAutor().getId(),
                topico.getCurso().getId()
        ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> retornaDatosTopico(@PathVariable Long id){

        service.validar(id);

        Topico topico = topicoRepository.getReferenceById(id);

        var datosTopico = new DatosRespuestaTopico(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getAutor().getId(),
                topico.getCurso().getId()
        );

        return ResponseEntity.ok(datosTopico);
    }
}
