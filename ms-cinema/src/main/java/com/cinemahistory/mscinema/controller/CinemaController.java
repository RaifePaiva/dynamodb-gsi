package com.cinemahistory.mscinema.controller;

import com.cinemahistory.mscinema.dto.FilmeDTO;
import com.cinemahistory.mscinema.service.FilmeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/filmes")
public class CinemaController {

    private final FilmeService service;

    public CinemaController(FilmeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> cadastrar(@Valid @RequestBody FilmeDTO filme){
        service.cadastrarFilme(filme);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cadastrado com sucesso");
    }

    @GetMapping("{ano}/{titulo}")
    public ResponseEntity<FilmeDTO> buscarFilme(@PathVariable Integer ano, @PathVariable String titulo){
        FilmeDTO filme = service.buscarFilme(ano, titulo);
        return ResponseEntity.status(HttpStatus.OK).body(filme);
    }

    @GetMapping("{genero}")
    public ResponseEntity<List<FilmeDTO>> listarFilmes(@PathVariable String genero){
        List<FilmeDTO> filmes = service.listarFilmes(genero);
        return ResponseEntity.ok().body(filmes);
    }

}
