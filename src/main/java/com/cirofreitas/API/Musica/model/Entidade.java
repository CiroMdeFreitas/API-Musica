package com.cirofreitas.API.Musica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Entidade extends ObjetoDominio {
    @Column(name = "descricao")
    private String descricao;

    @Column(name = "popularidade")
    private Integer popularidade;

    public String getDescricao() {
        return descricao;
    }

    public Integer getPopularidade() {
        return popularidade;
    }
}
