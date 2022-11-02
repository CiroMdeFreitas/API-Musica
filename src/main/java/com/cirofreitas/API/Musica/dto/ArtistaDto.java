package com.cirofreitas.API.Musica.dto;

public class ArtistaDto {
    private String nome;
    private String descricao;
    private Double popularidade;
    private String tipo;

    public ArtistaDto(String nome, String descricao, Double popularidade, String tipo) {
        this.nome = nome;
        this.descricao = descricao;
        this.popularidade = popularidade;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getPopularidade() {
        return popularidade;
    }

    public String getTipo() {
        return tipo;
    }
}
