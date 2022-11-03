package com.cirofreitas.API.Musica.repository;

import com.cirofreitas.API.Musica.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {
    @Query(value =
            "SELECT * " +
            "FROM tab_album album, tab_origem origem " +
            "WHERE " +
            "album.id = origem.entidade_id " +
            "AND " +
            "origem.id_origem = ?1",
            nativeQuery = true)
    Optional<Album> findAlbumByOrigem(String idOrigem);

    @Query(value =
            "SELECT * " +
            "FROM tab_album " +
            "ORDER BY tab_album.popularidade DESC " +
            "LIMIT 10",
            nativeQuery = true)
    List<Album> listarTopTenAlbum();

    @Query(value =
            "SELECT DISTINCT album.* " +
            "FROM tab_album album, tab_artista artista, artista_album relacao " +
            "WHERE " +
            "album.id = relacao.album_id " +
            "AND " +
            "relacao.artista_id = ?1 " +
            "ORDER BY album.popularidade DESC " +
            "LIMIT 5",
            nativeQuery = true)
    Optional<Album> listarTop5AlbumDeArtista(Integer idArtista);
}
