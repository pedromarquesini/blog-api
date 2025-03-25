package com.example.demo.service;

import com.example.demo.model.Autor;
import com.example.demo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    public Optional<Autor> findById(Long id) {
        return autorRepository.findById(id);
    }

    public Autor salvarAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    public void deletarAutor(Long id) {
        autorRepository.deleteById(id);
    }

    public List<Autor> findByNome(String nome) {
        return autorRepository.findByNomeContaining(nome);
    }

}
