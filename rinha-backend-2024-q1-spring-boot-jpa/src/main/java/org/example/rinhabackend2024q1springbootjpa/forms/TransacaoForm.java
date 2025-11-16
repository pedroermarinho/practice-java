package org.example.rinhabackend2024q1springbootjpa.forms;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Tag(
        name = "TransacaoForm",
        description = "Formulario para transacao"
)
public record TransacaoForm(
        @Schema(description = "Valor da transacao", example = "1000")
        @NotNull
        @Positive
        Integer valor,
        @Schema(description = "Tipo da transacao", example = "c")
        @NotNull
        Character tipo,
        @Schema(description = "Descricao da transacao", example = "descricao")
        @NotBlank
        @Size(min = 1, max = 10)
        String descricao
) {
}
