package com.cirofreitas.API.Musica.service;

import com.cirofreitas.API.Musica.dto.MusicaDto;
import com.cirofreitas.API.Musica.model.Musica;
import com.cirofreitas.API.Musica.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicaService {
    @Autowired
    private MusicaRepository repository;

    public void save(MusicaDto musica) {
        Musica novaMusica = musica.dtoToMusica();
        List<Musica> musicas = repository.findAll();
        int indiceMusica = musicas.indexOf(novaMusica);
        if(indiceMusica == -1)
            repository.save(novaMusica);
    }
}
