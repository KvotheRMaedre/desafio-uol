package tech.kvothe.desafio_uol.dto;

import java.util.List;

public record VingadoresDto(List<Codinome> vingadores) implements CodinomeDto {

    @Override
    public List<String> getCodinomes() {
        return vingadores
                .stream()
                .map(Codinome::codinome)
                .toList();
    }
}

record Codinome (String codinome) {

}
