package com.cirofreitas.API.Musica.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tab_album")
public class Album extends Entidade {
    @Column(name = "data_lacamento")
    private LocalDate dataLacamento;

    @Column(name = "tipo")
    private String tipo;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "album_id")
    private List<Musica> musicas = new ArrayList<Musica>();

    public LocalDate getDataLacamento() {
        return dataLacamento;
    }

    public String getTipo() {
        return tipo;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }
}
