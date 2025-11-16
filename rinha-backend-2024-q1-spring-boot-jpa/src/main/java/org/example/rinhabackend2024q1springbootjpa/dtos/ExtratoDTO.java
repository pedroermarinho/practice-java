package org.example.rinhabackend2024q1springbootjpa.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(
        name = "ExtratoDTO",
        description = "DTO para extrato"
)
public record ExtratoDTO (
        SaldoDTO saldo,
        @JsonProperty("ultimas_transacoes")
        List<TransacaoDTO> ultimasTransacoes
){
}
