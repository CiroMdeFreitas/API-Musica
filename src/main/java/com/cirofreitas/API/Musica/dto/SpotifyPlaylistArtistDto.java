package com.cirofreitas.API.Musica.dto;

public class SpotifyPlaylistArtistDto {
    private String id;
    private String name;
    private String type;

    public ArtistaDto toArtistaDto() {
        return new ArtistaDto(
                id,
                "Spotify",
                name,
                type
        );
    }

    public void setId(String id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setType(String type) { this.type = type; }
}
