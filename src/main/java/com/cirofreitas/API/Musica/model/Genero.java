package com.cirofreitas.API.Musica.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "tab_genero")
public class Genero extends ObjetoDominio {
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Genero) {
            Genero genero = (Genero) obj;

            return Objects.equals(this.getNome(), genero.getNome());
        }

        return false;
    }
}
