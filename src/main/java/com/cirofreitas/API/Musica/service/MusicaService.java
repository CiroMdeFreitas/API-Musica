package com.cirofreitas.API.Musica.service;

import com.cirofreitas.API.Musica.dto.MusicaDto;
import com.cirofreitas.API.Musica.infra.MissingEntityException;
import com.cirofreitas.API.Musica.model.Musica;
import com.cirofreitas.API.Musica.model.Origem;
import com.cirofreitas.API.Musica.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicaService {
    @Autowired
    private MusicaRepository repository;

    public Musica findById(Integer id) {
        Optional<Musica> musica = repository.findById(id);

        if(musica.isPresent())
            throw new MissingEntityException("Não foi encontrado nenhum album com este id!");

        return musica.get();
    }

    public List<Origem> listarOrigens(Integer id) { return this.findById(id).getOrigens(); }

    public void save(MusicaDto musica) {
        Optional<Musica> musicaPresente = repository.findMusicaByOrigem(musica.getIdOrigem());
        if(!musicaPresente.isPresent())
            repository.save(musica.dtoToModel());
    }
}
