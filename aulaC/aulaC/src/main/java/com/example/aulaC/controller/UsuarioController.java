package com.example.aulaC.controller;


import com.example.aulaC.model.Usuario;
import com.example.aulaC.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    @GetMapping
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) {
        usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @PutMapping
    public ResponseEntity<Usuario> ati(@RequestBody Usuario usuario) {
        if(usuarioRepository.existsById(usuario.getId())){
            usuarioRepository.save(usuario);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        usuarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}