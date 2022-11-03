package com.cirofreitas.API.Musica.service;

import com.cirofreitas.API.Musica.dto.MusicaDto;
import com.cirofreitas.API.Musica.model.Musica;
import com.cirofreitas.API.Musica.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MusicaService {
    @Autowired
    private MusicaRepository repository;

    public void save(MusicaDto musica) {
        Optional<Musica> musicaPresente = repository.findMusicaByOrigem(musica.getIdOrigem());
        if(!musicaPresente.isPresent())
            repository.save(musica.dtoToModel());
    }
}
