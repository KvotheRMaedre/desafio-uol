package tech.kvothe.desafio_uol.entity;

public record Jogador(
        String nome,
        String email,
        String telefone,
        String codinome,
        GrupoCodinome grupoCodinome) {
}
