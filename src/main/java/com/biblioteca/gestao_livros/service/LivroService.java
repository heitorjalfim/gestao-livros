package com.biblioteca.gestao_livros.service;

import com.biblioteca.gestao_livros.model.*;
import com.biblioteca.gestao_livros.repository.*;
import lombok.RequiredArgsConstructor;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LivroService {
    private final LivroRepository repository;

    public List<Livro> listarLivros(){
        return repository.findAll();
    }
    
    public Livro buscarLivro(Long id){
        return repository.findById(id)
            .orElseThrow(() -> new jakarta.persistence.EntityNotFoundException());
    }

    public Livro salvar(Livro livro){
        if (repository.existsByTitulo(livro.getTitulo())) {
            throw new RuntimeException();
        }
        livro.setTitulo(livro.getTitulo().toUpperCase());
        return repository.save(livro);
    }
        
    public Livro atualizar(Long id, Livro dadosAtualizados){
        Livro livroExistente = buscarLivro(id);

        livroExistente.setAno(dadosAtualizados.getAno());
        livroExistente.setAutor(dadosAtualizados.getAutor());
        livroExistente.setTitulo(dadosAtualizados.getTitulo());
        
        return repository.save(livroExistente);
    }
    
    public void excluir(Long id){
        Livro livro = buscarLivro(id);
        repository.delete(livro);
    }

}
