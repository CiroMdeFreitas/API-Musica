package com.cirofreitas.API.Musica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "tab_origem")
public class Origem extends ObjetoDominio {
    @Column(name = "id_origem")
    private String idOrigem;

    public String getIdOrigem() {
        return idOrigem;
    }

    public void setIdOrigem(String idOrigem) { this.idOrigem = idOrigem; }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Origem) {
            Origem origem = (Origem) obj;

            return (Objects.equals(this.getNome(), origem.getNome()) &&
                    Objects.equals(this.idOrigem, origem.getIdOrigem()));
        }

        return false;
    }
}
