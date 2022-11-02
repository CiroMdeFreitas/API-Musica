package com.cirofreitas.API.Musica.controller;

import com.cirofreitas.API.Musica.dto.GeneroDto;
import com.cirofreitas.API.Musica.model.Genero;
import com.cirofreitas.API.Musica.repository.GeneroRepository;
import com.cirofreitas.API.Musica.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/genero")
public class GeneroController {
    @Autowired
    private GeneroRepository repository;

    @Autowired
    private GeneroService service;

    @GetMapping
    public List<Genero> findAll() {
        return repository.findAll();
    }

    @PostMapping
    public void save(@RequestBody GeneroDto genero){
        service.save(genero);
    }
}
