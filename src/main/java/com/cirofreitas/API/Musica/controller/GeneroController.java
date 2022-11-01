package com.cirofreitas.API.Musica.controller;

import com.cirofreitas.API.Musica.model.Genero;
import com.cirofreitas.API.Musica.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/genero")
public class GeneroController {
    @Autowired
    private GeneroRepository repository;

    @GetMapping
    public List<Genero> fiddAll() {
        return repository.findAll();
    }
}
