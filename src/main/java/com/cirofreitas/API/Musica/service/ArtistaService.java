package com.cirofreitas.API.Musica.service;

import com.cirofreitas.API.Musica.dto.ArtistaDto;
import com.cirofreitas.API.Musica.infra.MissingEntityException;
import com.cirofreitas.API.Musica.model.Album;
import com.cirofreitas.API.Musica.model.Artista;
import com.cirofreitas.API.Musica.model.Musica;
import com.cirofreitas.API.Musica.model.Origem;
import com.cirofreitas.API.Musica.repository.AlbumRepository;
import com.cirofreitas.API.Musica.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistaService {
    @Autowired
    private ArtistaRepository repository;

    @Autowired
    private AlbumRepository albumRepository;

    public Artista findById(Integer id) {
        Optional<Artista> artista  = repository.findById(id);

        if(!artista.isPresent())
            throw new MissingEntityException("Não foi encontrado nenhum artista com este id!");

        return artista.get();
    }

    public List<Album> listarAlbuns(Integer id) { return this.findById(id).getAlbuns(); }

    public List<Musica> listarMusicas(Integer id) {
        List<Musica> musicas = new ArrayList<Musica>();

        for(Album album : this.findById(id).getAlbuns())
            for(Musica musica: album.getMusicas())
                musicas.add(musica);

        return musicas;
    }

    public List<Origem> listarOrigens(Integer id) { return this.findById(id).getOrigens(); }

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
