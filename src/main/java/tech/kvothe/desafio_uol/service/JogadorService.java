package tech.kvothe.desafio_uol.service;

import org.springframework.stereotype.Service;
import tech.kvothe.desafio_uol.model.GrupoCodinome;
import tech.kvothe.desafio_uol.model.Jogador;
import tech.kvothe.desafio_uol.repository.JogadorRepository;

import java.util.List;

@Service
public class JogadorService {

    private final JogadorRepository jogadorRepository;
    private final CodinomeService codinomeService;

    public JogadorService(JogadorRepository jogadorRepository, CodinomeService codinomeService) {
        this.jogadorRepository = jogadorRepository;
        this.codinomeService = codinomeService;
    }

    public Jogador registrarJogador(Jogador jogador) throws Exception {
        var codinomesEmUso = listarCodinomeEmUso(jogador.grupoCodinome());
        var novoCodinome = codinomeService.gerarCodinome(jogador.grupoCodinome(), codinomesEmUso);

        var novoJogador = new Jogador(
                jogador.nome(),
                jogador.email(),
                jogador.telefone(),
                novoCodinome,
                jogador.grupoCodinome()
        );
        return jogadorRepository.salvar(novoJogador);
    }

    private List<String> listarCodinomeEmUso(GrupoCodinome grupoCodinome) {
        return jogadorRepository.listarCodinomesPorGrupo(grupoCodinome);
    }
}
