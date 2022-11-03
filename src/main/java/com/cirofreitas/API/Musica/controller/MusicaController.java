package com.cirofreitas.API.Musica.controller;

import com.cirofreitas.API.Musica.dto.MusicaDto;
import com.cirofreitas.API.Musica.model.Musica;
import com.cirofreitas.API.Musica.model.Origem;
import com.cirofreitas.API.Musica.repository.MusicaRepository;
import com.cirofreitas.API.Musica.service.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/musicas")
public class MusicaController {
    @Autowired
    private MusicaRepository repository;

    @Autowired
    private MusicaService service;

    @GetMapping
    public List<Musica> findAll() {
        return repository.findAll();
    }

    @GetMapping("top10")
    public List<Musica> listTopTenMusica() {
        return repository.listarTopDezMusicas();
    }

    @GetMapping("{id}")
    public Musica findById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }

    @GetMapping("{id}/origens")
    public List<Origem> listarOrigens(@PathVariable("id") Integer id) { return service.listarOrigens(id); }

    @PostMapping
    public void save(@RequestBody MusicaDto musica) { service.save(musica); }
}
