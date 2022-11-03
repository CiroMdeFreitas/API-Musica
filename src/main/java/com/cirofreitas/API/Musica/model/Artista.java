package com.cirofreitas.API.Musica.model;

import com.cirofreitas.API.Musica.dto.ArtistaDto;
import com.cirofreitas.API.Musica.infra.BusinessException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tab_artista")
public class Artista extends Entidade {
    @Column(name="tipo")
    private String tipo;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "artista_album",
            joinColumns = {
                    @JoinColumn(name = "artista_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "album_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private List<Album> albuns = new ArrayList<Album>();

    public void validarDto(ArtistaDto dto) {
        String nome = dto.getNome();
        if(nome == null || nome.trim().isEmpty())
            throw new BusinessException("Não foi informado nome de artista!");

        String tipo = dto.getTipo();
        if(tipo == null || tipo.trim().isEmpty())
            throw new BusinessException("Não foi informado tipo de artista!");
    }

    public void adicionarAlbum(Album album) {
        if(!this.albuns.contains(album))
            this.albuns.add(album);
    }

    public void setAlbum(int indice, Album albumAtualizado) {
        this.albuns.set(indice, albumAtualizado);
    }

    public List<Album> getAlbuns() { return albuns; }

    public void setTipo(String tipo) { this.tipo = tipo; }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Artista) {
            Artista artista = (Artista) obj;

            return Objects.equals(this.getNome(), artista.getNome());
        }

        return false;
    }
}
