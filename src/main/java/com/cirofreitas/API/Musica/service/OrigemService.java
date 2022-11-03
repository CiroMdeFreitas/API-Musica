package com.cirofreitas.API.Musica.service;

import com.cirofreitas.API.Musica.infra.MissingEntityException;
import com.cirofreitas.API.Musica.model.Origem;
import com.cirofreitas.API.Musica.repository.OrigemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrigemService {
    @Autowired
    private OrigemRepository repository;

    public Origem findById(Integer id) {
        Optional<Origem> origem = repository.findById(id);

        if(origem.isPresent())
            throw new MissingEntityException("Não foi encontrado nenhum album com este id!");

        return origem.get();
    }
}
