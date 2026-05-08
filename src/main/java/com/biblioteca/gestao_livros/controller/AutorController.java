package com.biblioteca.gestao_livros.controller;

import com.biblioteca.gestao_livros.service.*;
import com.biblioteca.gestao_livros.model.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.*;

@RestController
@RequestMapping("/autores")
@RequiredArgsConstructor
public class AutorController {
    private final AutorService service;

    @GetMapping()
    public List<Autor> listarAutores() {
        return service.listarAutores();
    }
    
    @GetMapping("/{id}")
    public Autor buscarAutor(@PathVariable Long id){
        return service.buscarAutor(id);
    }

    @PostMapping
    @ResponseStatus(org.springframework.http.HttpStatus.CREATED)
    public Autor salvar(@RequestBody Autor autor){
        return service.salvar(autor);
    }

    @PutMapping("/{id}")
    public Autor atualizar(@PathVariable Long id, @RequestBody Autor dadosAtualizados){
        return service.atualizar(id, dadosAtualizados);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        service.excluir(id);
    }
}
