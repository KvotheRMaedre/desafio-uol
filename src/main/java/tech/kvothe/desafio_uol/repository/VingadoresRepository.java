package tech.kvothe.desafio_uol.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;
import tech.kvothe.desafio_uol.dto.VingadoresDto;
import tech.kvothe.desafio_uol.model.GrupoCodinome;

import java.util.List;

public class VingadoresRepository implements CodinomeRepository{

    @Override
    public List<String> buscarCodinomes() throws JsonProcessingException {
        var codinomes = RestClient.builder()
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN_VALUE)
                .baseUrl(GrupoCodinome.VINGADORES.getUri())
                .build()
                .get()
                .retrieve()
                .body(String.class);

        var objectMapper = new ObjectMapper();
        var vingadores = objectMapper.readValue(codinomes, VingadoresDto.class);

        return vingadores.getCodinomes();

    }
}
