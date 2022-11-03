package com.cirofreitas.API.Musica.repository;

import com.cirofreitas.API.Musica.model.Album;
import com.cirofreitas.API.Musica.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {
    @Query("SELECT album FROM tab_album album, tab_origem origem WHERE album.id = origem.entidade_id AND origem.id_origem = ?1")
    Optional<Album> findAlbumByOrigem(String idOrigem);
}
