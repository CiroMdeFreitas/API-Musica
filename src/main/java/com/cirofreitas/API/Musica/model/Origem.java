package com.cirofreitas.API.Musica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tab_origem")
public class Origem extends ObjetoDominio {
    @Column(name = "id_origem")
    private String idOrigem;

    public String getIdOrigem() {
        return idOrigem;
    }
}
