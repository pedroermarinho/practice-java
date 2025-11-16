package org.example.rinhabackend2024q1springbootjpa.dtos;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(
        name = "LimiteESaldoDTO",
        description = "DTO para limite e saldo")
public record LimiteESaldoDTO(
        Integer limite,
        Integer saldo
) {
}
