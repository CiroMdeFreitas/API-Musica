package com.cirofreitas.API.Musica.dto;

import com.cirofreitas.API.Musica.model.Album;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AlbumDto {
    private String idOrigem;
    private String nomeOrigem;
    private String nome;
    private String tipo;
    private Year anoLacamento;
    private List<MusicaDto> musicas;

    public AlbumDto(String idOrigem, String nomeOrigem, String nome, String tipo, Year anoLacamento) {
        this.idOrigem = idOrigem;
        this.nomeOrigem = nomeOrigem;
        this.nome = nome;
        this.tipo = tipo;
        this.anoLacamento = anoLacamento;
        this.musicas = new ArrayList<MusicaDto>();
    }

    public void adicionarMusicaDto(MusicaDto musica) {
        if(!this.musicas.contains(musica))
            musicas.add(musica);
    }

    public Album dtoToModel() {
        Album novoAlbum = new Album();
        novoAlbum.validarDto(this);

        novoAlbum.setOrigem(idOrigem, nomeOrigem);
        novoAlbum.setNome(this.nome);
        novoAlbum.setTipo(this.tipo);
        novoAlbum.setAnoLacamento(this.anoLacamento.toString());

        for(MusicaDto musica : this.musicas)
            novoAlbum.adicionarMusica(musica.dtoToModel());

        return novoAlbum;
    }

    public String getIdOrigem() { return idOrigem; }

    public String getNome() { return nome; }

    public String getTipo() { return tipo; }

    public Year getAnoLacamento() { return anoLacamento; }

    public List<MusicaDto> getMusicas() { return musicas; }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof AlbumDto) {
            AlbumDto album = (AlbumDto) obj;

            return Objects.equals(this.getIdOrigem(), album.getIdOrigem());
        }

        return false;
    }
}
