package com.cirofreitas.API.Musica.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Entidade extends ObjetoDominio {
    @Column(name = "descricao")
    private String descricao;

    @Column(name = "popularidade")
    private Integer popularidade;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "entidade_id")
    private List<Origem> origens = new ArrayList<>();

    public String getDescricao() {
        return descricao;
    }

    public Integer getPopularidade() {
        return popularidade;
    }
}
