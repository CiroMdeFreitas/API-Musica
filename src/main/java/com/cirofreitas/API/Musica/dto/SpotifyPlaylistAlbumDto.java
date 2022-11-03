package com.cirofreitas.API.Musica.dto;

import java.time.Year;
import java.util.List;
import java.util.Objects;

public class SpotifyPlaylistAlbumDto {
    private String id;
    private String name;
    private String album_type;
    private String release_date;
    private List<SpotifyPlaylistArtistDto> artists;

    public AlbumDto toAlbumDto() {
        Year anoLancamento;
        if(release_date.length() == 4)
            anoLancamento = Year.parse(release_date);
        else
            anoLancamento = Year.parse(release_date.substring(0, 4));

        return new AlbumDto(
                id,
                "Spotify",
                name,
                album_type,
                anoLancamento
        );
    }

    public void setId(String id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setAlbum_type(String album_type) { this.album_type = album_type; }

    public void setRelease_date(String release_date) { this.release_date = release_date; }

    public void setArtists(List<SpotifyPlaylistArtistDto> artists) { this.artists = artists; }

    public List<SpotifyPlaylistArtistDto> getArtists() { return artists; }
}
