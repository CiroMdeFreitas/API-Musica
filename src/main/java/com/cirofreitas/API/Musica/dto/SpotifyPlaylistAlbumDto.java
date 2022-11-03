package com.cirofreitas.API.Musica.dto;

import java.time.LocalDate;
import java.util.List;

public class SpotifyPlaylistAlbumDto {
    private String id;
    private String name;
    private String album_type;
    private LocalDate release_date;
    private List<SpotifyPlaylistArtistDto> artists;

    public AlbumDto toAlbumDto() {
        return new AlbumDto(
                id,
                "Spotify",
                name,
                album_type,
                release_date
        );
    }

    public void setId(String id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setAlbum_type(String album_type) { this.album_type = album_type; }

    public void setRelease_date(LocalDate release_date) { this.release_date = release_date; }

    public void setArtists(List<SpotifyPlaylistArtistDto> artists) { this.artists = artists; }

    public List<SpotifyPlaylistArtistDto> getArtists() { return artists; }
}
