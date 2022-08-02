package com.cinemahistory.mscinema.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.cinemahistory.mscinema.domain.Filme;
import com.cinemahistory.mscinema.dto.FilmeDTO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FilmeRepository {

    private final DynamoDBMapper dynamoDBMapper;

    public FilmeRepository(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public void salvar(Filme filme){
        try{
            dynamoDBMapper.save(filme);
        }catch (Exception e){
            throw new RuntimeException("Erro ao salvar.");
        }
    }

    public FilmeDTO buscarFilme(Integer ano, String titulo) {
        try{
            Filme filme = dynamoDBMapper.load(Filme.class, ano, titulo);
            return new FilmeDTO(filme);
        }catch (Exception e){
            throw new RuntimeException("Erro ao buscar dados no banco.");
        }
    }

    public List<FilmeDTO> listarFilmes(String genero) {
        try{
            Map<String, AttributeValue> params = new HashMap<String, AttributeValue>();
            params.put(":genero", new AttributeValue().withS(genero));

            DynamoDBQueryExpression<Filme> queryExpression = new DynamoDBQueryExpression<Filme>()
                    .withIndexName("generoIndex")
                    .withConsistentRead(false)
                    .withKeyConditionExpression("genero = :genero")
                    .withExpressionAttributeValues(params);
            List<Filme> filmes = dynamoDBMapper.query(Filme.class, queryExpression);
            return new FilmeDTO().toDto(filmes);
        }catch (Exception e){
            throw new RuntimeException("Erro ao buscar dados no banco.");
        }
    }
}
