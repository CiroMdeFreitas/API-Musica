package com.cirofreitas.API.Musica.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tab_musica")
public class Musica extends Entidade {
    @Column(name = "duracao")
    private Integer duracao;

    @Column(name = "explicito")
    private Boolean explicito;

    @ElementCollection
    @CollectionTable(
            name = "tab_musica_genero",
            joinColumns=@JoinColumn(name = "musica_id", referencedColumnName = "id")
    )
    @Column(name="genero")
    private List<Genero> generos;

    public Integer getDuracao() {
        return duracao;
    }

    public Boolean getExplicito() {
        return explicito;
    }

    public List<Genero> getGeneros() {
        return generos;
    }
}
