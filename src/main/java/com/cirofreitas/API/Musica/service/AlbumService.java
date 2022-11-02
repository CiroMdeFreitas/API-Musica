package com.cirofreitas.API.Musica.service;

import com.cirofreitas.API.Musica.dto.AlbumDto;
import com.cirofreitas.API.Musica.model.Album;
import com.cirofreitas.API.Musica.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepository repository;

    public void save(AlbumDto album) {
        Album novoAlbum = new Album();
        novoAlbum.validarDto(album);

        List<Album> albuns = repository.findAll();
        novoAlbum.setNome(album.getNome());
        if(!albuns.contains(novoAlbum)) {
            novoAlbum.setPopularidade(album.getPopularidade());
            novoAlbum.setTipo(album.getTipo());
            novoAlbum.setDataLacamento(album.getDataLacamento());

            repository.save(novoAlbum);
        }
    }
}
