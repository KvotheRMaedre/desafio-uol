package tech.kvothe.desafio_uol.model;

public record Jogador(
        String nome,
        String email,
        String telefone,
        String codinome,
        GrupoCodinome grupoCodinome) {
}
