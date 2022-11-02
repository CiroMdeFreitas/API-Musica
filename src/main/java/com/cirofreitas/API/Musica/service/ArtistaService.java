package com.cirofreitas.API.Musica.service;

import com.cirofreitas.API.Musica.dto.ArtistaDto;
import com.cirofreitas.API.Musica.model.Artista;
import com.cirofreitas.API.Musica.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistaService {
    @Autowired
    private ArtistaRepository repository;

    public void save(ArtistaDto artista) {
        Artista novoArtista = new Artista();
        novoArtista.validarDto(artista);

        novoArtista.setNome(artista.getNome());
        List<Artista> artistas = repository.findAll();
        if(artistas.contains(novoArtista)) {
            novoArtista.setPopularidade(artista.getPopularidade());
            novoArtista.setTipo(artista.getTipo());

            repository.save(novoArtista);
        }
    }
}
