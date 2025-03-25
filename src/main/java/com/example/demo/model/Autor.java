package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String descricao;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Postagem> postagens = new ArrayList<>();

    public Autor() {

    }

    //metodos adicionais
    public void adicionarPostagem(Postagem postagem) {
        postagens.add(postagem);
        postagem.setAutor(this);
    }

    public void removerPostagem(Postagem postagem) {
        postagens.remove(postagem);
        postagem.setAutor(null);
    }
}
