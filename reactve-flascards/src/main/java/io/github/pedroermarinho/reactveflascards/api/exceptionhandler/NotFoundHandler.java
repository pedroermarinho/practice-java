package io.github.pedroermarinho.reactveflascards.api.exceptionhandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.pedroermarinho.reactveflascards.domain.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class NotFoundHandler extends AbstractHandleException<NotFoundException> {
    public NotFoundHandler(ObjectMapper objectMapper) {
        super(objectMapper);
    }

    @Override
    Mono<Void> handleException(ServerWebExchange exchange, NotFoundException ex) {
        return Mono.fromCallable(() -> {
                    prepareExchege(exchange, HttpStatus.NOT_FOUND);
                    return ex.getMessage();
                }).map(message -> buildError(HttpStatus.NOT_FOUND, message))
                .doFirst(() -> log.error("==== NotFoundException:", ex))
                .flatMap(problemResponse -> writeResponse(exchange, problemResponse));
    }
}
