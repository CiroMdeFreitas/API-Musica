package com.cirofreitas.API.Musica.dto;

public class ArtistaDto {
    private String nome;
    private Double popularidade;
    private String tipo;

    public ArtistaDto(String nome, String descricao, Double popularidade, String tipo) {
        this.nome = nome;
        this.popularidade = popularidade;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public Double getPopularidade() {
        return popularidade;
    }

    public String getTipo() {
        return tipo;
    }
}
