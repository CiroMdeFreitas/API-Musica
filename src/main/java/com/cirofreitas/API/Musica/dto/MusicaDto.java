package com.cirofreitas.API.Musica.dto;

public class MusicaDto {
    private String nome;
    private Double popularidade;
    private Integer duracao;
    private Boolean explicito;

    public MusicaDto(String nome, Double popularidade, Integer duracao, Boolean explicito) {
        this.nome = nome;
        this.popularidade = popularidade;
        this.duracao = duracao;
        this.explicito = explicito;
    }

    public String getNome() {
        return nome;
    }

    public Double getPopularidade() {
        return popularidade;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public Boolean getExplicito() {
        return explicito;
    }
}
