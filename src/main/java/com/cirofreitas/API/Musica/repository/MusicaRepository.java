package com.cirofreitas.API.Musica.repository;

import com.cirofreitas.API.Musica.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Integer> {
    @Query("SELECT musica FROM tab_musica musica, tab_origem origem WHERE musica.id = origem.entidade_id AND origem.id_origem = ?1")
    Musica findMusicaByOrigem(String idOrigem);
}
