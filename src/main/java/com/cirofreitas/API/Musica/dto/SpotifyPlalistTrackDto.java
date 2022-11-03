package com.cirofreitas.API.Musica.dto;

import java.time.LocalDate;
import java.util.List;

public class SpotifyPlalistTrackDto {
    private String id;
    private String name;
    private Double popularity;
    private Integer duration_ms;
    private Boolean explicit;
    private SpotifyPlaylistAlbumDto album;

    public MusicaDto toMusicaDto() {
        return new MusicaDto(
                id,
                "Spotify",
                name,
                popularity,
                duration_ms,
                explicit
        );
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public void setDuration_ms(Integer duration_ms) {
        this.duration_ms = duration_ms;
    }

    public void setExplicit(Boolean explicit) {
        this.explicit = explicit;
    }

    public void setAlbum(SpotifyPlaylistAlbumDto album) {
        this.album = album;
    }

    public SpotifyPlaylistAlbumDto getAlbum() { return album; }
}
