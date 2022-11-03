package com.cirofreitas.API.Musica.controller;

import com.cirofreitas.API.Musica.dto.AlbumDto;
import com.cirofreitas.API.Musica.model.Album;
import com.cirofreitas.API.Musica.model.Musica;
import com.cirofreitas.API.Musica.model.Origem;
import com.cirofreitas.API.Musica.repository.AlbumRepository;
import com.cirofreitas.API.Musica.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/albuns")
public class AlbumController {
    @Autowired
    private AlbumRepository repository;

    @Autowired
    private AlbumService service;

    @GetMapping
    public List<Album> findAll() {
        return repository.findAll();
    }

    @GetMapping("top10")
    public List<Album> listTopTenAlbum() {
        return repository.listarTopDezAlbum();
    }

    @GetMapping("{id}")
    public Album findById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }

    @GetMapping("{id}/musicas")
    public List<Musica> listarMusicas(@PathVariable("id") Integer id) { return service.listarMusicas(id); }

    @GetMapping("{id}/musicas/top")
    public Musica listarTopMusicaDeAlbum(@PathVariable("id") Integer id) { return service.listarTopMusicaDeAlbum(id); }

    @GetMapping("{id}/origens")
    public List<Origem> listarOrigens(@PathVariable("id") Integer id) { return service.listarOrigens(id); }

    @PostMapping
    public void save(@RequestBody AlbumDto album) { service.save(album); }
}
