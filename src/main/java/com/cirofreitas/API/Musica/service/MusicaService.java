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
        Musica novaMusica = new Musica();
        novaMusica.validarDto(musica);

        novaMusica.setNome(musica.getNome());
        List<Musica> musicas = repository.findAll();
        if(!musicas.contains(novaMusica)) {
            novaMusica.setDescricao(musica.getDescricao());
            novaMusica.setPopularidade(musica.getPopularidade());
            novaMusica.setDuracao(musica.getDuracao());
            novaMusica.setExplicito(musica.getExplicito());

            repository.save(novaMusica);
        }
    }
}
