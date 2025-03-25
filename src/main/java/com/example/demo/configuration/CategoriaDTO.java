package com.example.demo.configuration;

import com.example.demo.model.Categoria;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class CategoriaDTO {
    private Long id;
    private String nome;
    private Long categoriaPaiId;
    private List<CategoriaDTO> subCategorias;

    public static CategoriaDTO fromEntity(Categoria categoria) {
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.id = categoria.getId();
        categoriaDTO.nome = categoria.getNome();
        if(categoriaDTO.categoriaPaiId != null) {
            categoriaDTO.setCategoriaPaiId(categoria.getCategoriaPai().getId());
        }
        if(categoria.getSubcategorias() != null) {
            categoriaDTO.setSubCategorias(categoria.getSubcategorias()
                                        .stream()
                                        .map(CategoriaDTO::fromEntity)
                                        .collect(Collectors.toList()
                                    )
            );
        }
        return categoriaDTO;
    }
}
