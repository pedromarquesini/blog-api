package com.example.demo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Postagem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String conteudo;
    private LocalDateTime data;
    private int quantidadeExibicoes;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;

    @OneToMany()
    private List<Categoria> categorias = new ArrayList<>();

    public Postagem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public int getQuantidadeExibicoes() {
        return quantidadeExibicoes;
    }

    public void setQuantidadeExibicoes(int quantidadeExibicoes) {
        this.quantidadeExibicoes = quantidadeExibicoes;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    //Metodos adicionais
    public void adicionarCategoria(Categoria categoria) {
        this.categorias.add(categoria);
    }
    public void removerCategoria(Categoria categoria) {
        this.categorias.remove(categoria);
    }
}
