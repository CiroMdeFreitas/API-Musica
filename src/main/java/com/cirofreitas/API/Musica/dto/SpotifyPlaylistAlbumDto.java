package com.cirofreitas.API.Musica.dto;

import java.time.Year;
import java.util.List;
import java.util.Objects;

public class SpotifyPlaylistAlbumDto {
    private String id;
    private String name;
    private String album_type;
    private String release_date_precision;
    private Year release_date;
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

    public void setRelease_date_precision(String release_date_precision) {
        this.release_date_precision = release_date_precision;
    }

    public void setRelease_date(String release_date) {
        if(Objects.equals(this.release_date_precision, "year"))
            this.release_date = Year.parse(release_date);
        else
            this.release_date = Year.parse(release_date.substring(0, 4));
    }

    public void setArtists(List<SpotifyPlaylistArtistDto> artists) { this.artists = artists; }

    public List<SpotifyPlaylistArtistDto> getArtists() { return artists; }
}
