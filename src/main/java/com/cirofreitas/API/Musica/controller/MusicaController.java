package com.cirofreitas.API.Musica.controller;

import com.cirofreitas.API.Musica.dto.MusicaDto;
import com.cirofreitas.API.Musica.model.Musica;
import com.cirofreitas.API.Musica.repository.MusicaRepository;
import com.cirofreitas.API.Musica.service.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/musica")
public class MusicaController {
    @Autowired
    private MusicaRepository repository;

    @Autowired
    private MusicaService service;

    @GetMapping
    public List<Musica> findAll() {
        return repository.findAll();
    }

    @PostMapping
    public void save(@RequestBody MusicaDto musica) { service.save(musica); }
}
