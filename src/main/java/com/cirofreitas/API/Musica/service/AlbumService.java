package com.cirofreitas.API.Musica.service;

import com.cirofreitas.API.Musica.dto.AlbumDto;
import com.cirofreitas.API.Musica.model.Album;
import com.cirofreitas.API.Musica.model.Musica;
import com.cirofreitas.API.Musica.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepository repository;

    public void save(AlbumDto album) {
        Album novoAlbum = album.dtoToModel();
        Optional<Album> albumPresente = repository.findAlbumByOrigem(album.getIdOrigem());

        if(albumPresente.isPresent()) {
            Album albumRegitrado = albumPresente.get();

            for(Musica musica : novoAlbum.getMusicas())
                if(!albumRegitrado.getMusicas().contains(musica))
                    albumRegitrado.adicionarMusica(musica);

            repository.save(albumRegitrado);
        } else
            repository.save(novoAlbum);
    }
}
