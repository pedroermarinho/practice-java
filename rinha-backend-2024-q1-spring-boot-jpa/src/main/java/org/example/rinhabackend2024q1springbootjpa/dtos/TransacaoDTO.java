package org.example.rinhabackend2024q1springbootjpa.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.time.LocalDateTime;

@Tag(
        name = "TransacaoDTO",
        description = "DTO para transacao"
)
public record TransacaoDTO(
        Integer valor,
        Character tipo,
        String descricao,
        @JsonProperty("realizada_em")
        LocalDateTime realizadaEm
) {
}
