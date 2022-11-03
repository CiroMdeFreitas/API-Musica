package com.cirofreitas.API.Musica.repository;

import com.cirofreitas.API.Musica.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Integer> {
    @Query(value = "SELECT * FROM tab_artista artista, tab_origem origem WHERE artista.id = origem.entidade_id AND origem.id_origem = ?1", nativeQuery = true)
    Optional<Artista> findArtistaByOrigem(String idOrigem);

    @Query(value = "SELECT * FROM tab_artista ORDER BY tab_artista.popularidade DESC LIMIT 10", nativeQuery = true)
    List<Artista> listTopTenArtistas();
}
