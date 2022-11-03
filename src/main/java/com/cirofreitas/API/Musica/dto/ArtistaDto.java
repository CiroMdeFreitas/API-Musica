package com.cirofreitas.API.Musica.dto;

import com.cirofreitas.API.Musica.model.Artista;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ArtistaDto {
    private String idOrigem;
    private String nomeOrigem;
    private String nome;
    private String tipo;
    private List<AlbumDto> albuns;

    public ArtistaDto(String idOrigem, String nomeOrigem, String nome, String tipo) {
        this.idOrigem = idOrigem;
        this.nomeOrigem = nomeOrigem;
        this.nome = nome;
        this.tipo = tipo;
        this.albuns = new ArrayList<AlbumDto>();
    }

    public void adicionarAlbum(AlbumDto album) {
        int indiceAlbum = this.albuns.indexOf(album);

        if(indiceAlbum != -1){
            AlbumDto updatedAlbum = this.albuns.get(indiceAlbum);

            album.getMusicas().forEach(updatedAlbum::adicionarMusicaDto);

            this.albuns.set(indiceAlbum, updatedAlbum);
        } else
            this.albuns.add(album);
    }

    public Artista dtoToModel() {
        Artista novoArtista = new Artista();
        novoArtista.validarDto(this);

        novoArtista.setOrigem(this.idOrigem, this.nomeOrigem);
        novoArtista.setNome(this.nome);
        novoArtista.setTipo(this.tipo);

        for(AlbumDto album : this.albuns)
            novoArtista.adicionarAlbum(album.dtoToModel());

        return novoArtista;
    }

    public String getIdOrigem() { return idOrigem; }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public List<AlbumDto> getAlbuns() { return albuns; }

    public void setAlbuns(List<AlbumDto> albuns) { this.albuns = albuns; }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ArtistaDto) {
            ArtistaDto artista = (ArtistaDto) obj;

            return Objects.equals(this.getIdOrigem(), artista.getIdOrigem());
        }

        return false;
    }
}
