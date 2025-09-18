package tech.kvothe.desafio_uol.exception;

public class GrupoCodinomeIndisponivelException extends IllegalArgumentException {

    public GrupoCodinomeIndisponivelException() {
        super("Não há condinomes disponíveis para o grupo selecionado.");
    }
}
