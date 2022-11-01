package com.cirofreitas.API.Musica.controller;

import com.cirofreitas.API.Musica.model.Musica;
import com.cirofreitas.API.Musica.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/musica")
public class MusicaController {
    @Autowired
    private MusicaRepository repository;

    @GetMapping
    public List<Musica> fiddAll() {
        return repository.findAll();
    }
}
