package tech.kvothe.desafio_uol.repository;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import tech.kvothe.desafio_uol.model.GrupoCodinome;
import tech.kvothe.desafio_uol.model.Jogador;

import java.util.List;

@Repository
public class JogadorRepository {
    private final JdbcClient jdbcClient;

    public JogadorRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public Jogador salvar(Jogador jogador) {
        jdbcClient.sql("""
                INSERT INTO JOGADORES (nome, email, telefone, codinome, grupo_codinome)
                VALUES (:nome, :email, :telefone, :codinome, :grupo_codinome)
                """)
                .param("nome", jogador.nome())
                .param("email", jogador.email())
                .param("telefone", jogador.telefone())
                .param("codinome", jogador.codinome())
                .param("grupo_codinome", jogador.grupoCodinome())
                .update();
        return jogador;
    }

    public List<String> listarCodinomesPorGrupo(GrupoCodinome grupoCodinome) {
        return jdbcClient.sql("SELECT distinct(codinome) FROM JOGADORES WHERE grupo_codinome = :=grupo_codinome")
                .param("grupo_codinome", grupoCodinome.getNome())
                .query(String.class)
                .list();
    }
}
