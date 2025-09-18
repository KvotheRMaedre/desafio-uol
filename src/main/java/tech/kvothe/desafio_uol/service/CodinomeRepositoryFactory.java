package tech.kvothe.desafio_uol.service;

import org.springframework.stereotype.Component;
import tech.kvothe.desafio_uol.model.GrupoCodinome;
import tech.kvothe.desafio_uol.repository.CodinomeRepository;
import tech.kvothe.desafio_uol.repository.LigaDaJusticaRepository;
import tech.kvothe.desafio_uol.repository.VingadoresRepository;

@Component
public class CodinomeRepositoryFactory {

    private final LigaDaJusticaRepository ligaDaJusticaRepository;
    private final VingadoresRepository vingadoresRepository;

    public CodinomeRepositoryFactory(LigaDaJusticaRepository ligaDaJusticaRepository, VingadoresRepository vingadoresRepository) {
        this.ligaDaJusticaRepository = ligaDaJusticaRepository;
        this.vingadoresRepository = vingadoresRepository;
    }

    public CodinomeRepository create(GrupoCodinome grupoCodinome) {
        return switch (grupoCodinome) {
            case LIGA_DA_JUSTICA -> ligaDaJusticaRepository;
            case VINGADORES -> vingadoresRepository;
        };
    }
}
