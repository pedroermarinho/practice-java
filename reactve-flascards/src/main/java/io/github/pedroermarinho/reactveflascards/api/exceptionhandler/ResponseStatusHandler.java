package io.github.pedroermarinho.reactveflascards.api.exceptionhandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.pedroermarinho.reactveflascards.domain.exception.BaseErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class ResponseStatusHandler extends AbstractHandleException<ResponseStatusException> {
    public ResponseStatusHandler(ObjectMapper objectMapper) {
        super(objectMapper);
    }

    @Override
    Mono<Void> handleException(ServerWebExchange exchange, ResponseStatusException ex) {
        return Mono.fromCallable(() -> {
                    prepareExchege(exchange, HttpStatus.INTERNAL_SERVER_ERROR);
                    return BaseErrorMessage.GENERIC_EXCEPTION.getMessage();
                }).map(message -> buildError(HttpStatus.INTERNAL_SERVER_ERROR, message))
                .doFirst(() -> log.error("==== ResponseStatusException:", ex))
                .flatMap(problemResponse -> writeResponse(exchange, problemResponse));
    }
}
