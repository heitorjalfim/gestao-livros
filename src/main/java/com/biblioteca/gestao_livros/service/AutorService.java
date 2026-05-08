package com.biblioteca.gestao_livros.service;

import org.springframework.stereotype.Service;

import com.biblioteca.gestao_livros.model.*;
import com.biblioteca.gestao_livros.repository.*;
import lombok.RequiredArgsConstructor;
import java.util.*;

@Service
@RequiredArgsConstructor
public class AutorService {
    private final AutorRepository repository;

    public List<Autor> listarAutores(){
        return repository.findAll();
    }

    public Autor buscarAutor(Long id){
        return repository.findById(id)
            .orElseThrow(() -> new jakarta.persistence.EntityNotFoundException("ID nao encontrado."));
    }

    public Autor salvar(Autor autor){
        if (repository.existsByNome(autor.getNome())) {
            throw new RuntimeException("Autor ja cadastrado.");
        }
        autor.setNome(autor.getNome().toUpperCase());
        return repository.save(autor);
    }

    public Autor atualizar(Long id, Autor dadosAtualizados){
        Autor autorExistente = buscarAutor(id);
        
        autorExistente.setNacionalidade(dadosAtualizados.getNacionalidade());
        autorExistente.setNome(dadosAtualizados.getNome());

        return repository.save(autorExistente);
    }

    public void excluir(Long id){
        //se tiver livros cadastrados nao pode ser deletado
        repository.deleteById(id);
    }
}
