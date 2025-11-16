package io.github.pedroermarinho.reactveflascards.api.exceptionhandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.pedroermarinho.reactveflascards.domain.exception.BaseErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class MethodNotAllowedHandler extends AbstractHandleException<MethodNotAllowedException> {
    public MethodNotAllowedHandler(ObjectMapper objectMapper) {
        super(objectMapper);
    }

    @Override
    Mono<Void> handleException(ServerWebExchange exchange, MethodNotAllowedException ex) {
        return Mono.fromCallable(() -> {
                    prepareExchege(exchange, HttpStatus.METHOD_NOT_ALLOWED);
                    return BaseErrorMessage.GENERIC_METHOD_NOT_ALLOWED.param(exchange.getRequest().getMethod().name()).getMessage();
                }).map(message -> buildError(HttpStatus.METHOD_NOT_ALLOWED, message))
                .doFirst(() -> log.error("==== MethodNotAllowedException: Method [{}] is not allowed at [{}]",
                        exchange.getRequest().getMethod(), exchange.getRequest().getPath().value(), ex))
                .flatMap(problemResponse -> writeResponse(exchange, problemResponse));
    }
}
