package com.cirofreitas.API.Musica.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Entidade extends ObjetoDominio {
    @Column(name = "popularidade")
    private Double popularidade;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "entidade_id")
    private List<Origem> origens = new ArrayList<>();

    public Double getPopularidade() { return popularidade; }

    public void setPopularidade(Double popularidade) { this.popularidade = popularidade; }

    public List<Origem> getOrigens() { return origens; }

    public void setOrigens(List<Origem> origens) { this.origens = origens; }
}
