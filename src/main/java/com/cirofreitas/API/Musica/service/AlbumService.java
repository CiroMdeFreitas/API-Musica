package com.cirofreitas.API.Musica.service;

import com.cirofreitas.API.Musica.dto.AlbumDto;
import com.cirofreitas.API.Musica.infra.MissingEntityException;
import com.cirofreitas.API.Musica.model.Album;
import com.cirofreitas.API.Musica.model.Musica;
import com.cirofreitas.API.Musica.model.Origem;
import com.cirofreitas.API.Musica.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepository repository;

    public Album findById(Integer id) {
        Optional<Album> album = repository.findById(id);
        System.out.println(id);

        if(!album.isPresent())
            throw new MissingEntityException("Não foi encontrado nenhum album com este id!");

        return album.get();
    }

    public List<Origem> listarOrigens(Integer id) { return this.findById(id).getOrigens(); }

    public List<Musica> listarMusicas(Integer id) { return this.findById(id).getMusicas(); }

    public Musica listarTopMusicaDeAlbum(Integer id) {
        Album album = this.findById(id);
        Musica topMusica = new Musica();
        topMusica.setPopularidade(0.00);

        for(Musica musica : album.getMusicas())
            if(musica.getPopularidade() > topMusica.getPopularidade())
                topMusica = musica;

        return topMusica;
    }

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
