package com.alura.controller;

import com.alura.domain.usuario.*;
import com.alura.domain.usuario.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/usuarios")
@SecurityRequirement(name = "bearer-key")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private RegistroDeUsuarioService usuarioService;

    @PostMapping
    @Transactional
    public ResponseEntity registroUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario){
        repository.save(new Usuario(datosRegistroUsuario.nombre(),datosRegistroUsuario.email(),datosRegistroUsuario.contrasena()));
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoUsuarios>> listaUsuarios(@PageableDefault(size = 5, sort = "id")Pageable paginacion){
        return ResponseEntity.ok(repository.findAll(paginacion).map(DatosListadoUsuarios::new));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarUsuario(@PathVariable Long id){
        usuarioService.validarExistencia(id);
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarUsuario(@RequestBody @Valid DatosActualizarUsuario datosActualizarUsuario){
        usuarioService.actualizar(datosActualizarUsuario);
        return ResponseEntity.ok().build();
    }
}
