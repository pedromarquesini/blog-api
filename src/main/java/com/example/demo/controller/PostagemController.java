package com.example.demo.controller;

import com.example.demo.model.Postagem;
import com.example.demo.service.PostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postagens")
public class PostagemController {

    @Autowired
    private PostagemService postagemService;

    @GetMapping
    public List<Postagem> listarTodas() {
        return postagemService.findAllPostagem();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Postagem> buscarPorId(@PathVariable Long id) {
        return postagemService.findPostagemById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Postagem salvarPostagem(Postagem postagem) {
        return postagemService.salvarPostagem(postagem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Postagem> atualizar(@PathVariable Long id, @RequestBody Postagem postagem) {
        if(!postagemService.findPostagemById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        postagem.setId(id);
        return ResponseEntity.ok(postagemService.salvarPostagem(postagem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if(!postagemService.findPostagemById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        postagemService.deletarPostagem(id);
        return ResponseEntity.noContent().build();
    }

}
