package com.cirofreitas.API.Musica.controller;

import com.cirofreitas.API.Musica.dto.ArtistaDto;
import com.cirofreitas.API.Musica.model.Album;
import com.cirofreitas.API.Musica.model.Artista;
import com.cirofreitas.API.Musica.model.Musica;
import com.cirofreitas.API.Musica.model.Origem;
import com.cirofreitas.API.Musica.repository.ArtistaRepository;
import com.cirofreitas.API.Musica.service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/artistas")
public class ArtistaController {
    @Autowired
    private ArtistaRepository repository;

    @Autowired
    private ArtistaService service;

    @GetMapping
    public List<Artista> findAll() {
        return repository.findAll();
    }

    @GetMapping("top10")
    public List<Artista> listTopTenArtistas() {
        return repository.listTopTenArtistas();
    }

    @GetMapping("{id}")
    public Artista findById(@PathVariable("id") Integer id) { return service.findById(id); }

    @GetMapping("{id}/albuns")
    public List<Album> listarAlbuns(@PathVariable("id") Integer id) { return service.listarAlbuns(id); }

    @GetMapping("{id}/albuns/top5")
    public List<Album> listarTopCincoAlbuns(@PathVariable("id") Integer id) { return service.listarAlbuns(id); }

    @GetMapping("{id}/musicas")
    public List<Musica> listarMusicas(@PathVariable("id") Integer id) { return service.listarMusicas(id); }

    @GetMapping("{id}/origens")
    public List<Origem> listarOrigens(@PathVariable("id") Integer id) { return service.listarOrigens(id); }

    @PostMapping
    public void save(@RequestBody ArtistaDto artista) { service.save(artista); }
}
