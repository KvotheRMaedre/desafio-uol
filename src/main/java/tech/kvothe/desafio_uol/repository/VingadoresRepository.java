package tech.kvothe.desafio_uol.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;
import tech.kvothe.desafio_uol.dto.CodinomeDto;
import tech.kvothe.desafio_uol.dto.VingadoresDto;
import tech.kvothe.desafio_uol.model.GrupoCodinome;

import java.util.List;

@Repository
public class VingadoresRepository implements CodinomeRepository{

    @Override
    public CodinomeDto buscarCodinomes() throws JsonProcessingException {
        var codinomes = RestClient.builder()
                .baseUrl(GrupoCodinome.VINGADORES.getUri())
                .build()
                .get()
                .retrieve()
                .body(String.class);

        var objectMapper = new ObjectMapper();

        return objectMapper.readValue(codinomes, VingadoresDto.class);

    }
}
