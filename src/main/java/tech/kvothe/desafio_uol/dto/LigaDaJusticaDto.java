package tech.kvothe.desafio_uol.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "liga_da_justica")
public record LigaDaJusticaDto(
        @JacksonXmlProperty(localName = "codinomes") CodinomesDto codinomes) implements CodinomeDto {

    @Override
    public List<String> getCodinomes() {
        return codinomes.codinomes();
    }
}

record CodinomesDto(
        @JacksonXmlElementWrapper(useWrapping = false) @JacksonXmlProperty(localName = "codinome") List<String> codinomes) {

}