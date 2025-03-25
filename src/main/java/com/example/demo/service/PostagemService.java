package com.example.demo.service;

import com.example.demo.model.Postagem;
import com.example.demo.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostagemService {

    @Autowired
    private PostagemRepository postagemRepository;

    public List<Postagem> findAllPostagem() {
        return postagemRepository.findAll();
    }

    public Optional<Postagem> findPostagemById(Long id) {
        return postagemRepository.findById(id);
    }

    public Postagem salvarPostagem(Postagem postagem) {
        return postagemRepository.save(postagem);
    }

    public void deletarPostagem(Long id) {
        postagemRepository.deleteById(id);
    }

}
