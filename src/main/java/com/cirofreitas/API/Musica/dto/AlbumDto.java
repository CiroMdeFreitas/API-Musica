package com.cirofreitas.API.Musica.dto;

import java.time.LocalDate;

public class AlbumDto {
    private String nome;
    private String descricao;
    private Double popularidade;
    private LocalDate dataLacamento;
    private String tipo;

    public AlbumDto(String nome, String descricao, Double popularidade, LocalDate dataLacamento, String tipo) {
        this.nome = nome;
        this.descricao = descricao;
        this.popularidade = popularidade;
        this.dataLacamento = dataLacamento;
        this.tipo = tipo;
    }

    public String getNome() { return nome; }

    public String getDescricao() { return descricao; }

    public Double getPopularidade() { return popularidade; }

    public LocalDate getDataLacamento() { return dataLacamento; }

    public String getTipo() { return tipo; }
}
