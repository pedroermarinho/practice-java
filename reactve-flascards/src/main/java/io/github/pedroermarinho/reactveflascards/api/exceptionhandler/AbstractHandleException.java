package io.github.pedroermarinho.reactveflascards.api.exceptionhandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.pedroermarinho.reactveflascards.api.controller.response.ProblemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.OffsetDateTime;


@RequiredArgsConstructor
public abstract class AbstractHandleException<T extends Exception> {

    protected final ObjectMapper objectMapper;

    abstract Mono<Void> handleException(final ServerWebExchange exchange, final T ex);

    protected Mono<Void> writeResponse(final ServerWebExchange exchange, final ProblemResponse problemResponse) {
        return exchange.getResponse()
                .writeWith(Mono.fromCallable(() -> new DefaultDataBufferFactory().wrap(objectMapper.writeValueAsBytes(problemResponse))));
    }


    protected void prepareExchege(final ServerWebExchange exchange, final HttpStatus status) {
        exchange.getResponse().setStatusCode(status);
        exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);
    }

    protected ProblemResponse buildError(final HttpStatus status, final String errorDescription) {
        return ProblemResponse.builder()
                .status(status.value())
                .errorDescription(errorDescription)
                .timestamp(OffsetDateTime.now())
                .build();
    }
}
