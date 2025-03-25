package com.example.demo.controller;

import com.example.demo.model.Autor;
import com.example.demo.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public List<Autor> listarTodos() {
        return autorService.findAll();
    }

    @GetMapping("/{nome}")
    public List<Autor> buscaAutorByNome(@PathVariable String nome) {
        return autorService.findByNome(nome);
    }

    @PostMapping
    public Autor salvarAutor(Autor autor) {
        return autorService.salvarAutor(autor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> atualizarAutor(@PathVariable Long id,@RequestBody Autor autor) {
        if(!autorService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        autor.setId(id);
        return ResponseEntity.ok(autorService.salvarAutor(autor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Autor> deletarAutor(@PathVariable Long id) {
        if(!autorService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        autorService.deletarAutor(id);
        return ResponseEntity.ok(autorService.findById(id).get());
    }

}
