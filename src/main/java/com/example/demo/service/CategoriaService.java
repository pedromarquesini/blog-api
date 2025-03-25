package com.example.demo.service;

import com.example.demo.model.Categoria;
import com.example.demo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAllCategoria() {
        return categoriaRepository.findAll();
    }

    public List<Categoria> listarSubcategorias(Long categoriaPaiId) {
        return categoriaRepository.findByCategoriaPaiId(categoriaPaiId);
    }

    public Optional<Categoria> buscarPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    public Categoria salvarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public void excluirCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }


}
