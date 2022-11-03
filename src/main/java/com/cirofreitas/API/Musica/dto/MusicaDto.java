package com.cirofreitas.API.Musica.dto;

import com.cirofreitas.API.Musica.model.Musica;

import java.util.Objects;

public class MusicaDto {
    private String idOrigem;
    private String nomeOrigem;
    private String nome;
    private Double popularidade;
    private Integer duracao;
    private Boolean explicito;

    public MusicaDto(String idOrigem, String nomeOrigem, String nome, Double popularidade, Integer duracao, Boolean explicito) {
        this.idOrigem = idOrigem;
        this.nomeOrigem = nomeOrigem;
        this.nome = nome;
        this.popularidade = popularidade;
        this.duracao = duracao;
        this.explicito = explicito;
    }

    public Musica dtoToModel() {
        Musica novaMusica = new Musica();
        novaMusica.validarDto(this);

        novaMusica.setOrigem(idOrigem, nomeOrigem);
        novaMusica.setNome(this.nome);
        novaMusica.setPopularidade(this.popularidade);
        novaMusica.setDuracao(this.duracao);
        novaMusica.setExplicito(this.explicito);

        return novaMusica;
    }

    public String getIdOrigem() { return idOrigem; }

    public String getNome() { return nome; }

    public Double getPopularidade() { return popularidade; }

    public Integer getDuracao() { return duracao; }

    public Boolean getExplicito() { return explicito; }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof MusicaDto) {
            MusicaDto musica = (MusicaDto) obj;

            return Objects.equals(this.idOrigem, musica.getIdOrigem());
        }

        return false;
    }
}
