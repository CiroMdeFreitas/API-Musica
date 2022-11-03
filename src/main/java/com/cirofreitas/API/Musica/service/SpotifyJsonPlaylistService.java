package com.cirofreitas.API.Musica.service;

import com.cirofreitas.API.Musica.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpotifyJsonPlaylistService {
    @Autowired
    private ArtistaService artistaService;

    public void consumirPlaylist(SpotifyPlaylistHeaderDto playlist) {
        List<ArtistaDto> novosArtistas = new ArrayList<ArtistaDto>();

        for(SpotifyPlaylistItemDto item : playlist.getTracks().getItems()) {
            SpotifyPlalistTrackDto track = item.getTrack();
            MusicaDto novaMusica = track.toMusicaDto();

            SpotifyPlaylistAlbumDto album = track.getAlbum();
            AlbumDto novoAlbum = album.toAlbumDto();
            novoAlbum.adicionarMusicaDto(novaMusica);

            List<SpotifyPlaylistArtistDto> artists = album.getArtists();
            artists.forEach((artist) -> {
                ArtistaDto novoArtista = artist.toArtistaDto();
                int indiceArtista = novosArtistas.indexOf(novoArtista);

                if(indiceArtista != -1) {
                    novoArtista.setAlbuns(novosArtistas.get(indiceArtista).getAlbuns());
                }
                novoArtista.adicionarAlbum(novoAlbum);

                novosArtistas.add(novoArtista);
            });
        }

        novosArtistas.forEach((novoArtista) -> artistaService.save(novoArtista));
    }
}