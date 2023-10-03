package com.alura.controller;

import com.alura.domain.respuesta.*;
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

@RestController
@RequestMapping("/respuestas")
@SecurityRequirement(name = "bearer-key")
public class RespuestaController {

    @Autowired
    private RegistroRespuestaService service;

    @Autowired
    private RespuestaRepository respuestaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity registrarRespuesta(@RequestBody @Valid DatosRespuesta datosRespuesta,
                                             UriComponentsBuilder uriComponentsBuilder){
        Respuesta respuesta = service.registrar(datosRespuesta);
        URI uri = uriComponentsBuilder.path("/respuestas/{id}").buildAndExpand(respuesta.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoRespuestas>> listadoRespuestas(@PageableDefault(size = 5,sort = "id")Pageable paginacion){
        return ResponseEntity.ok(respuestaRepository.findAll(paginacion).map(DatosListadoRespuestas::new));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminaRespuesta(@PathVariable Long id){
        service.validarExistencia(id);
        respuestaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizaRespuesta(@RequestBody @Valid DatosActualizarRespuesta datosActualizarRespuesta){
        service.actualizar(datosActualizarRespuesta);
        return ResponseEntity.ok(datosActualizarRespuesta);
    }
}