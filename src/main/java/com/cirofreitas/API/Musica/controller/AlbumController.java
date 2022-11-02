package com.cirofreitas.API.Musica.controller;

import com.cirofreitas.API.Musica.model.Album;
import com.cirofreitas.API.Musica.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/album")
public class AlbumController {
    @Autowired
    private AlbumRepository repository;

    @GetMapping
    public List<Album> findAll() {
        return repository.findAll();
    }
}
