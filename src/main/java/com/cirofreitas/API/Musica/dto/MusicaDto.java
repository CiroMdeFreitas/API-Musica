package com.cirofreitas.API.Musica.dto;

public class MusicaDto {
    private String nome;
    private String descricao;
    private Double popularidade;
    private Integer duracao;
    private Boolean explicito;

    public MusicaDto(String nome, String descricao, Double popularidade, Integer duracao, Boolean explicito) {
        this.nome = nome;
        this.descricao = descricao;
        this.popularidade = popularidade;
        this.duracao = duracao;
        this.explicito = explicito;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPopularidade() {
        return popularidade;
    }

    public void setPopularidade(Double popularidade) {
        this.popularidade = popularidade;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public Boolean getExplicito() {
        return explicito;
    }

    public void setExplicito(Boolean explicito) {
        this.explicito = explicito;
    }
}
