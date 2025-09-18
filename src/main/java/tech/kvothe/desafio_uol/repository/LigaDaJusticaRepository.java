package tech.kvothe.desafio_uol.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.web.client.RestClient;
import tech.kvothe.desafio_uol.dto.LigaDaJusticaDto;
import tech.kvothe.desafio_uol.model.GrupoCodinome;

import java.util.List;

public class LigaDaJusticaRepository implements CodinomeRepository{
    @Override
    public List<String> buscarCodinomes() throws JsonProcessingException {
        var codinomes = RestClient.builder()
                .baseUrl(GrupoCodinome.LIGA_DA_JUSTICA.getUri())
                .build()
                .get()
                .retrieve()
                .body(String.class);

        var xmlMapper = new XmlMapper();
        var ligaDaJustica = xmlMapper.readValue(codinomes, LigaDaJusticaDto.class);
        return ligaDaJustica.getCodinomes();
    }
}
