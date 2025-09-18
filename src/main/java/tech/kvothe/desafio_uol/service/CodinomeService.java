package tech.kvothe.desafio_uol.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;
import tech.kvothe.desafio_uol.model.GrupoCodinome;

import java.util.List;

@Service
public class CodinomeService {

    private final CodinomeRepositoryFactory codinomeRepositoryFactory;

    public CodinomeService(CodinomeRepositoryFactory codinomeRepositoryFactory) {
        this.codinomeRepositoryFactory = codinomeRepositoryFactory;
    }

    public String gerarCodinome(GrupoCodinome grupoCodinome, List<String> codinomeEmUso) throws Exception {
        var codinomesDisponiveis = listarCodinomesDisponiveis(grupoCodinome, codinomeEmUso);
        if (codinomesDisponiveis.isEmpty()) {
            throw new Exception("Não há codinomes disponíveis para o grupo " + grupoCodinome.getNome());
        }

        var codinomeSorteado = sortearCodinomes(codinomesDisponiveis);
        return codinomeSorteado;
    }

    private List<String> listarCodinomesDisponiveis(GrupoCodinome grupoCodinome, List<String> codinomeEmUso) throws JsonProcessingException {
        var codinomes = buscarCodinomes(grupoCodinome);

        return codinomes
                .stream()
                .filter(codinome -> !codinomeEmUso.contains(codinome))
                .toList();
    }

    private List<String> buscarCodinomes(GrupoCodinome grupoCodinome) throws JsonProcessingException {
        var codinomeRepository = codinomeRepositoryFactory.create(grupoCodinome);
        return codinomeRepository.buscarCodinomes();
    }

    private String sortearCodinomes(List<String> codinomesDisponiveis) {
        return codinomesDisponiveis
                .get((int) (Math.random() * codinomesDisponiveis.size()));
    }
}
