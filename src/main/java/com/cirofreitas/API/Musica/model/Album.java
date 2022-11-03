package com.cirofreitas.API.Musica.model;

import com.cirofreitas.API.Musica.dto.AlbumDto;
import com.cirofreitas.API.Musica.infra.BusinessException;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tab_album")
public class Album extends Entidade {
    @Column(name = "data_lacamento")
    private LocalDate dataLacamento;

    @Column(name = "tipo")
    private String tipo;

    @ManyToMany(mappedBy = "albuns", fetch = FetchType.LAZY)
    private List<Artista> artistas = new ArrayList<Artista>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "album_id")
    private List<Musica> musicas = new ArrayList<Musica>();

    public void validarDto(AlbumDto dto) {
        String nome = dto.getNome();
        if(nome == null || nome.trim().isEmpty())
            throw new BusinessException("Não foi informado nome de album!");

        String tipo = dto.getTipo();
        if(tipo == null || tipo.trim().isEmpty())
            throw new BusinessException("Não foi informado tipo de album!");

        LocalDate dataLacamento = dto.getDataLacamento();
        LocalDate agora = LocalDate.now();
        if(dataLacamento == null || dataLacamento.isAfter(agora))
            throw  new BusinessException("Data fornecida é inválida!");
    }

    public void adicionarMusica(Musica musica) {
        if(!this.musicas.contains(musica))
            this.musicas.add(musica);
    }

    public void gerarPopularidade() {
        Double novaPopularidade = 0.00;
        for(Musica musica : this.musicas)
            novaPopularidade += musica.getPopularidade();

        if(novaPopularidade > 0.00)
            this.setPopularidade(novaPopularidade/this.musicas.size());
        else
            this.setPopularidade(0.00);
    }

    public LocalDate getDataLacamento() { return dataLacamento; }

    public void setDataLacamento(LocalDate dataLacamento) { this.dataLacamento = dataLacamento; }

    public String getTipo() { return tipo; }

    public void setTipo(String tipo) { this.tipo = tipo; }

    public List<Musica> getMusicas() { return musicas; }

    public void setMusicas(List<Musica> musicas) { this.musicas = musicas; }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Album) {
            Album album = (Album) obj;

            return Objects.equals(this.getNome(), album.getNome());
        }

        return false;
    }
}
