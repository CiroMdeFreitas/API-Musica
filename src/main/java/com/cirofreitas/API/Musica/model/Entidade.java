package com.cirofreitas.API.Musica.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Entidade extends ObjetoDominio {
    @Column(name = "popularidade")
    private Double popularidade;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "entidade_id")
    private List<Origem> origens = new ArrayList<>();

    public void setOrigem(String idOrigem, String nomeOrigem) {
        Origem origem = new Origem();
        origem.setIdOrigem(idOrigem);
        origem.setNome(nomeOrigem);

        if(!origens.contains(origem))
            origens.add(origem);
    }

    public Double getPopularidade() { return popularidade; }

    public void setPopularidade(Double popularidade) { this.popularidade = popularidade; }

    public List<Origem> getOrigens() { return origens; }
}
