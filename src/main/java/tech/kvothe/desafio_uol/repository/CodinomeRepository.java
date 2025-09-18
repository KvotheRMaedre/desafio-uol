package tech.kvothe.desafio_uol.repository;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface CodinomeRepository {
    List<String> buscarCodinomes() throws JsonProcessingException;
}
