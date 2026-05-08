package com.biblioteca.gestao_livros.controller;

import com.biblioteca.gestao_livros.model.*;
import com.biblioteca.gestao_livros.service.*;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/livros")
@RequiredArgsConstructor
public class LivroController {
    private final LivroService service;

    @GetMapping
    public List<Livro> listarLivros(){
        return service.listarLivros();
    }    

    @GetMapping("/{id}")
    public Livro buscarLivro(@PathVariable Long id){
        return service.buscarLivro(id);
    }

    @PostMapping
    @ResponseStatus(org.springframework.http.HttpStatus.CREATED)
    public Livro salvar(@RequestBody Livro novoLivro){
        return service.salvar(novoLivro);
    }

    @PutMapping("/{id}")
    public Livro atualizar(@PathVariable Long id, @RequestBody Livro dadosAtualizados){
        return service.atualizar(id, dadosAtualizados);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        service.excluir(id);
    }
}
