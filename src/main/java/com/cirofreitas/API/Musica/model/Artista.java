package com.cirofreitas.API.Musica.model;

import javax.persistence.*;
import java.util.List;

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

    public List<Album> getAlbuns() {
        return albuns;
    }

    public String getTipo() { return tipo; }
}
