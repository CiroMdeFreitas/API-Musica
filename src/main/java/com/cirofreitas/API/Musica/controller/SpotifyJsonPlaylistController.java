package com.cirofreitas.API.Musica.controller;

import com.cirofreitas.API.Musica.dto.SpotifyPlaylistHeaderDto;
import com.cirofreitas.API.Musica.service.SpotifyJsonPlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/Spotify/JSON/playlist")
public class SpotifyJsonPlaylistController {
    @Autowired
    private SpotifyJsonPlaylistService service;

    @PostMapping
    public void save(@RequestBody SpotifyPlaylistHeaderDto playlist) { service.consumirPlaylist(playlist); }
}
