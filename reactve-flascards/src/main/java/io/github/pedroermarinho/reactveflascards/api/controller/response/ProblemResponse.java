package io.github.pedroermarinho.reactveflascards.api.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProblemResponse(
        Integer status,
        OffsetDateTime timestamp,
        String errorDescription,
        List<ErrorFieldResponse> errors
) {

    @Builder(toBuilder = true)
    public ProblemResponse{}
}
