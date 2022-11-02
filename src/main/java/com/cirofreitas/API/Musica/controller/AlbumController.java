package com.cirofreitas.API.Musica.controller;

import com.cirofreitas.API.Musica.dto.AlbumDto;
import com.cirofreitas.API.Musica.model.Album;
import com.cirofreitas.API.Musica.repository.AlbumRepository;
import com.cirofreitas.API.Musica.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/album")
public class AlbumController {
    @Autowired
    private AlbumRepository repository;

    @Autowired
    private AlbumService service;

    @GetMapping
    public List<Album> findAll() {
        return repository.findAll();
    }

    @PostMapping
    public void save(@RequestBody AlbumDto album) { service.save(album); }
}
