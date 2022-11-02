package com.cirofreitas.API.Musica.controller;

import com.cirofreitas.API.Musica.dto.ArtistaDto;
import com.cirofreitas.API.Musica.model.Artista;
import com.cirofreitas.API.Musica.repository.ArtistaRepository;
import com.cirofreitas.API.Musica.service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/artista")
public class ArtistaController {
    @Autowired
    private ArtistaRepository repository;

    @Autowired
    private ArtistaService service;

    @GetMapping
    public List<Artista> findAll() {
        return repository.findAll();
    }

    @PostMapping
    public void save(@RequestBody ArtistaDto artista) { service.save(artista); }
}
