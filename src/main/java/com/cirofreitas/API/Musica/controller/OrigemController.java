package com.cirofreitas.API.Musica.controller;

import com.cirofreitas.API.Musica.model.Origem;
import com.cirofreitas.API.Musica.repository.OrigemRepository;
import com.cirofreitas.API.Musica.service.OrigemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/origens")
public class OrigemController {
    @Autowired
    private OrigemRepository repository;

    @Autowired
    private OrigemService service;

    @GetMapping
    public List<Origem> findAll() {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public Origem findById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }
}
