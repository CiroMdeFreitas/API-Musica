package com.cirofreitas.API.Musica.service;

import com.cirofreitas.API.Musica.dto.AlbumDto;
import com.cirofreitas.API.Musica.dto.GeneroDto;
import com.cirofreitas.API.Musica.infra.BusinessException;
import com.cirofreitas.API.Musica.model.Genero;
import com.cirofreitas.API.Musica.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService {
    @Autowired
    private GeneroRepository repository;

    public void save(GeneroDto genero) {
        String nome = genero.getNome();
        if(nome == null || nome.trim().isEmpty())
            throw new BusinessException("Não foi informado nome de genero!");

        Genero novoGenero = new Genero();
        novoGenero.setNome(nome);
        List<Genero> generos = repository.findAll();
        if(!generos.contains(novoGenero)) {
            repository.save(novoGenero);
        }
    }
}
