package com.cirofreitas.API.Musica.dto;

import java.util.List;

public class SpotifyPlaylistHeaderDto {

    private PlaylistTrack tracks;

    public PlaylistTrack getTracks() { return tracks; }

    public void setTracks(PlaylistTrack tracks) { this.tracks = tracks; }

    public class PlaylistTrack {
        private List<SpotifyPlaylistItemDto> items;

        public List<SpotifyPlaylistItemDto> getItems() { return items; }

        public void setItems(List<SpotifyPlaylistItemDto> items) { this.items = items; }
    }
}
