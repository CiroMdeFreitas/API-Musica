package com.cirofreitas.API.Musica.controller;

import com.cirofreitas.API.Musica.model.Artista;
import com.cirofreitas.API.Musica.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/artista")
public class ArtistaController {
    @Autowired
    private ArtistaRepository repository;

    @GetMapping
    public List<Artista> fiddAll() {
        return repository.findAll();
    }
}
