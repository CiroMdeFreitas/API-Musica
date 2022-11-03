package com.cirofreitas.API.Musica.service;

import com.cirofreitas.API.Musica.dto.AlbumDto;
import com.cirofreitas.API.Musica.infra.MissingEntityException;
import com.cirofreitas.API.Musica.model.Album;
import com.cirofreitas.API.Musica.model.Musica;
import com.cirofreitas.API.Musica.model.Origem;
import com.cirofreitas.API.Musica.repository.AlbumRepository;
import com.cirofreitas.API.Musica.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepository repository;

    @Autowired
    private MusicaRepository musicaRepository;

    public Album findById(Integer id) {
        Optional<Album> album = repository.findById(id);
        System.out.println(id);

        if(!album.isPresent())
            throw new MissingEntityException("Não foi encontrado nenhum album com este id!");

        return album.get();
    }

    public List<Origem> listarOrigens(Integer id) { return this.findById(id).getOrigens(); }

    public List<Musica> listarMusicas(Integer id) { return this.findById(id).getMusicas(); }

    public Musica listarTopMusicaDeAlbum(Integer id) { return musicaRepository.listarTopMusicaDeAlbum(id); }

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
