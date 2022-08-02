package com.cinemahistory.mscinema.service.impl;

import com.cinemahistory.mscinema.domain.Filme;
import com.cinemahistory.mscinema.dto.FilmeDTO;
import com.cinemahistory.mscinema.repository.FilmeRepository;
import com.cinemahistory.mscinema.service.FilmeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeServiceImpl implements FilmeService {

    private final FilmeRepository repository;

    public FilmeServiceImpl(FilmeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void cadastrarFilme(FilmeDTO filme) {
        Filme novoFilme = filme.toDomain();
        repository.salvar(novoFilme);
    }

    @Override
    public FilmeDTO buscarFilme(Integer ano, String titulo) {
        return repository.buscarFilme(ano, titulo);
    }

    @Override
    public List<FilmeDTO> listarFilmes(String genero) {
        return repository.listarFilmes(genero);
    }
}
