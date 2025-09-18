package tech.kvothe.desafio_uol.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import tech.kvothe.desafio_uol.dto.CodinomeDto;

import java.util.List;

public interface CodinomeRepository {
    CodinomeDto buscarCodinomes() throws JsonProcessingException;
}
