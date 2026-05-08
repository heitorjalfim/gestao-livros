package com.biblioteca.gestao_livros.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2)
    @Setter private String nome;

    @NotBlank
    @Size(min = 2)
    @Setter private String nacionalidade;

}
