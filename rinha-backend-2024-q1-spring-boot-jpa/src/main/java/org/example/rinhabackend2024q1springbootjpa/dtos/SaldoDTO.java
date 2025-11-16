package org.example.rinhabackend2024q1springbootjpa.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.time.LocalDateTime;

@Tag(
        name = "SaldoDTO",
        description = "DTO para saldo"
)
public record SaldoDTO(
        Integer total,

        @JsonProperty("data_extrato")
        LocalDateTime dataExtrato,
        Integer limite
) {
}
