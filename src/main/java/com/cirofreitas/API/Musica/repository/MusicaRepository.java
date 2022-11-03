package com.cirofreitas.API.Musica.repository;

import com.cirofreitas.API.Musica.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Integer> {
    @Query(value = "SELECT * " +
            "FROM tab_musica musica, tab_origem origem " +
            "WHERE " +
            "musica.id = origem.entidade_id " +
            "AND " +
            "origem.id_origem = ?1",
            nativeQuery = true)
    Optional<Musica> findMusicaByOrigem(String idOrigem);

    @Query(value = "SELECT * " +
            "FROM tab_musica " +
            "ORDER BY tab_musica.popularidade DESC " +
            "LIMIT 10",
            nativeQuery = true)
    List<Musica> listTopTenMusica();
}
