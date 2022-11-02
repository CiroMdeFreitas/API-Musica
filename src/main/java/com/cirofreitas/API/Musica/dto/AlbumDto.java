package com.cirofreitas.API.Musica.dto;

import java.time.LocalDate;

public class AlbumDto {
    private String nome;
    private Double popularidade;
    private LocalDate dataLacamento;
    private String tipo;

    public AlbumDto(String nome, Double popularidade, LocalDate dataLacamento, String tipo) {
        this.nome = nome;
        this.popularidade = popularidade;
        this.dataLacamento = dataLacamento;
        this.tipo = tipo;
    }

    public String getNome() { return nome; }

    public Double getPopularidade() { return popularidade; }

    public LocalDate getDataLacamento() { return dataLacamento; }

    public String getTipo() { return tipo; }
}
