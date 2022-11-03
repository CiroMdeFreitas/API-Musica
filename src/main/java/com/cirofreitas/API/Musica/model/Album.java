package com.cirofreitas.API.Musica.model;

import com.cirofreitas.API.Musica.dto.AlbumDto;
import com.cirofreitas.API.Musica.infra.BusinessException;

import javax.persistence.*;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.cirofreitas.API.Musica.util.DoubleHanfler.formatarParaDuasCasasDecimais;

@Entity
@Table(name = "tab_album")
public class Album extends Entidade {
    @Column(name = "ano_lacamento", columnDefinition = "VARCHAR(5)")
    private String anoLacamento;

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

        Year dataLacamento = dto.getAnoLacamento();
        Year agora = Year.now();
        if(dataLacamento == null || dataLacamento.isAfter(agora))
            throw  new BusinessException("Data fornecida é inválida!");
    }

    public void adicionarMusica(Musica musica) {
        if(!this.musicas.contains(musica)) {
            this.musicas.add(musica);
            this.gerarPopularidade();
        }
    }

    private void gerarPopularidade() {
        Double popularidade = 0.00;
        for(Musica musica : this.musicas)
            popularidade += musica.getPopularidade();

        if(popularidade > 0.00) {
            Double novaPopularidade = formatarParaDuasCasasDecimais(popularidade/this.musicas.size());
            this.setPopularidade(novaPopularidade);
        }
        else
            this.setPopularidade(1.00);
    }

    public String getAnoLacamento() { return anoLacamento; }

    public void setAnoLacamento(String anoLacamento) { this.anoLacamento = anoLacamento; }

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
