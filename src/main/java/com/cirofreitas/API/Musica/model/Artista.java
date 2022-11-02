package com.cirofreitas.API.Musica.model;

import com.cirofreitas.API.Musica.dto.ArtistaDto;
import com.cirofreitas.API.Musica.infra.BusinessException;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tab_artista")
public class Artista extends Entidade {
    @ElementCollection
    @CollectionTable(
            name = "tab_artista_album",
            joinColumns=@JoinColumn(name = "artista_id", referencedColumnName = "id")
    )
    @Column(name="album")
    private List<Album> albuns;

    @Column(name="tipo")
    private String tipo;

    public List<Album> getAlbuns() { return albuns; }

    public void setAlbuns(List<Album> albuns) { this.albuns = albuns; }

    public String getTipo() { return tipo; }

    public void setTipo(String tipo) { this.tipo = tipo; }

    public void validarDto(ArtistaDto dto) {
        String nome = dto.getNome();
        if(nome == null || nome.trim().isEmpty())
            throw new BusinessException("Não foi informado nome de artista!");

        Double popularidade = dto.getPopularidade();
        if(popularidade == null || popularidade < 0 || popularidade > 100)
            throw new BusinessException("Valor de popularidade é inválido!");

        String tipo = dto.getTipo();
        if(tipo == null || tipo.trim().isEmpty())
            throw new BusinessException("Não foi informado tipo de artista!");
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Artista) {
            Artista artista = (Artista) obj;

            return Objects.equals(this.getNome(), artista.getNome());
        }

        return false;
    }
}
