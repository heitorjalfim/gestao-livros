package com.biblioteca.gestao_livros.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @ManyToOne 
    @JoinColumn(name = "autor_id") 
    @Setter private Autor autor;

    @NotBlank
    @Size(min = 2)
    @Setter private String titulo;

    @Min(1000)
    @Setter private int ano;
}
