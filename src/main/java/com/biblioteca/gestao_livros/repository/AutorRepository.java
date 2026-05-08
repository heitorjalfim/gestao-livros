package com.biblioteca.gestao_livros.repository;

import com.biblioteca.gestao_livros.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{
    boolean existsByNome(String nome);
}
