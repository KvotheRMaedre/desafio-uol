package tech.kvothe.desafio_uol.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;
import tech.kvothe.desafio_uol.dto.CodinomeDto;
import tech.kvothe.desafio_uol.dto.LigaDaJusticaDto;
import tech.kvothe.desafio_uol.model.GrupoCodinome;

import java.util.List;

@Repository
public class LigaDaJusticaRepository implements CodinomeRepository{
    @Override
    public CodinomeDto buscarCodinomes() throws JsonProcessingException {
        var codinomes = RestClient.builder()
                .baseUrl(GrupoCodinome.LIGA_DA_JUSTICA.getUri())
                .build()
                .get()
                .retrieve()
                .body(String.class);

        var xmlMapper = new XmlMapper();
        return xmlMapper.readValue(codinomes, LigaDaJusticaDto.class);
    }
}
