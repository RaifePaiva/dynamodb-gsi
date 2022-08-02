package com.cinemahistory.mscinema.dto;

import com.cinemahistory.mscinema.domain.Filme;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

public class FilmeDTO {

    @NotNull
    private Integer ano;

    @NotBlank
    private String titulo;

    @NotBlank
    private String genero;

    @NotBlank
    private String diretor;

    @NotNull
    private Double nota;

    public FilmeDTO() {
    }

    public FilmeDTO(Integer ano, String titulo, String genero, String diretor, Double nota) {
        this.ano = ano;
        this.titulo = titulo;
        this.genero = genero;
        this.diretor = diretor;
        this.nota = nota;
    }

    public FilmeDTO(Filme filme) {
        this.ano = filme.getAno();
        this.titulo = filme.getTitulo();
        this.genero = filme.getGenero();
        this.diretor = filme.getDiretor();
        this.nota = filme.getNota();
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }


    public Filme toDomain(){
        return new Filme(this.ano, this.titulo, this.genero, this.diretor, this.nota);
    }

    public List<FilmeDTO> toDto(List<Filme> filmes) {
        return filmes.stream().map(filme -> new FilmeDTO(filme)).collect(Collectors.toList());
    }
}
