package com.cirofreitas.API.Musica.model;

import com.cirofreitas.API.Musica.dto.MusicaDto;
import com.cirofreitas.API.Musica.infra.BusinessException;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tab_musica")
public class Musica extends Entidade {
    @Column(name = "duracao")
    private Integer duracao;

    @Column(name = "explicito")
    private Boolean explicito;

    public void validarDto(MusicaDto dto) {
        String nome = dto.getNome();
        if(nome == null || nome.trim().isEmpty())
            throw new BusinessException("Não foi informado nome de musica!");

        Double popularidade = dto.getPopularidade();
        if(popularidade == null || popularidade < 0.00 || popularidade > 100.00)
            throw new BusinessException("Valor de popularidade é inválido!");

        Integer duracao = dto.getDuracao();
        if(duracao == null || popularidade <= 0)
            throw new BusinessException("Valor de popularidade é inválido!");

        Boolean explicito = dto.getExplicito();
        if(explicito == null)
            throw new BusinessException("Não foi informado se música possui conteúdo explicito!");
    }

    public Integer getDuracao() { return duracao; }

    public void setDuracao(Integer duracao) { this.duracao = duracao; }

    public Boolean getExplicito() { return explicito; }

    public void setExplicito(Boolean explicito) { this.explicito = explicito; }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Musica) {
            Musica musica = (Musica) obj;

            if(Objects.equals(this.getNome(), musica.getNome()))
                for(Origem origem : musica.getOrigens())
                    if(this.getOrigens().contains(origem))
                        return true;
        }

        return false;
    }
}
