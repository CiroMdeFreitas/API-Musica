package com.cirofreitas.API.Musica.service;

import com.cirofreitas.API.Musica.dto.ArtistaDto;
import com.cirofreitas.API.Musica.model.Album;
import com.cirofreitas.API.Musica.model.Artista;
import com.cirofreitas.API.Musica.model.Musica;
import com.cirofreitas.API.Musica.model.Origem;
import com.cirofreitas.API.Musica.repository.AlbumRepository;
import com.cirofreitas.API.Musica.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ArtistaService {
    @Autowired
    private ArtistaRepository repository;

    @Autowired
    private AlbumRepository albumRepository;

    public void save(ArtistaDto artista) {
        Artista novoArtista = artista.dtoToModel();
        Optional<Artista> artistaPresente = repository.findArtistaByOrigem(artista.getIdOrigem());

        if(artistaPresente.isPresent()) {
            Artista artistaRegistrado = artistaPresente.get();

            for(Album album : novoArtista.getAlbuns()) {
                int indiceAlbum = artistaRegistrado.getAlbuns().indexOf(album);

                if(indiceAlbum == -1)
                    artistaRegistrado.adicionarAlbum(album);
                else {
                    Album albumAtualizado = artistaRegistrado.getAlbuns().get(indiceAlbum);

                    for(Musica musica : album.getMusicas()) {
                        if(!albumAtualizado.getMusicas().contains(musica)) {
                            albumAtualizado.adicionarMusica(musica);
                            artistaRegistrado.setAlbum(indiceAlbum, albumAtualizado);
                        }
                    }
                }
            }

            repository.save(artistaRegistrado);
        } else {
            for(Album album : novoArtista.getAlbuns())
                for(Origem origem : album.getOrigens()) {
                    Optional<Album> albumPresente = albumRepository.findAlbumByOrigem(origem.getIdOrigem());

                    if(albumPresente.isPresent()) {
                        Album albumRegistrado = albumPresente.get();

                        for(Musica musica : album.getMusicas()) {
                            if(!albumRegistrado.getMusicas().contains(musica))
                                albumRegistrado.adicionarMusica(musica);
                        }

                        int indiceAlbum = novoArtista.getAlbuns().indexOf(album);
                        novoArtista.setAlbum(indiceAlbum, albumRegistrado);
                    }
                }

            repository.save(novoArtista);
        }
    }
}
