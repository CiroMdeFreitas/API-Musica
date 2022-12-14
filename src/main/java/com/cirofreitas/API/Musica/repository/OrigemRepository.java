package com.cirofreitas.API.Musica.repository;

import com.cirofreitas.API.Musica.model.Artista;
import com.cirofreitas.API.Musica.model.Origem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrigemRepository extends JpaRepository<Origem, Integer> {
    @Query(value =
            "SELECT * " +
            "FROM tab_origem origem " +
            "WHERE " +
            "origem.id_origem = ?1",
            nativeQuery = true)
    Artista findOrigemByIdOrigem(String idOrigem);
}
