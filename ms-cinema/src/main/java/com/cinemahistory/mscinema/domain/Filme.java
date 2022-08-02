package com.cinemahistory.mscinema.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

@DynamoDBTable(tableName = "tb_filmes")
public class Filme {

    @DynamoDBHashKey
    private Integer ano;

    @DynamoDBRangeKey
    @DynamoDBIndexRangeKey(globalSecondaryIndexName = "generoIndex")
    private String titulo;

    @DynamoDBAttribute
    @DynamoDBIndexHashKey(globalSecondaryIndexName = "generoIndex")
    private String genero;

    @DynamoDBAttribute
    private String diretor;

    @DynamoDBAttribute
    private Double nota;

    public Filme() {
    }

    public Filme(Integer ano, String titulo, String genero, String diretor, Double nota) {
        this.ano = ano;
        this.titulo = titulo;
        this.genero = genero;
        this.diretor = diretor;
        this.nota = nota;
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
}
