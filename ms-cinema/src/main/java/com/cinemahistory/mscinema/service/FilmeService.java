package com.cinemahistory.mscinema.service;

import com.cinemahistory.mscinema.dto.FilmeDTO;

import java.util.List;

public interface FilmeService {

    void cadastrarFilme(FilmeDTO filme);

    FilmeDTO buscarFilme(Integer ano, String titulo);

    List<FilmeDTO> listarFilmes(String genero);
}
