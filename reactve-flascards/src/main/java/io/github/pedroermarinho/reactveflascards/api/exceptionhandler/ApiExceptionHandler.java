package io.github.pedroermarinho.reactveflascards.api.exceptionhandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.pedroermarinho.reactveflascards.domain.exception.NotFoundException;
import io.github.pedroermarinho.reactveflascards.domain.exception.ReactiveFlashcardsException;
import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;

import java.util.Map;


@Component
@Order(-2)
@Slf4j
@AllArgsConstructor
public class ApiExceptionHandler implements WebExceptionHandler {


    private final MethodNotAllowedHandler methodNotAllowedHandler;
    private final NotFoundHandler notFoundHandler;
    private final ConstraintViolationHandler constraintViolationHandler;
    private final WebExchangeBindHandler webExchangeBindHandler;
    private final ResponseStatusHandler responseStatusHandler;
    private final ReactiveFlashcardsHandler reactiveFlashcardsHandler;
    private final GenericHandler genericHandler;
    private final JsonProcessingHandler jsonProcessingHandler;

    @Override
    public Mono<Void> handle(final ServerWebExchange exchange, final Throwable ex) {
        final Map<Class<?>, AbstractHandleException<?>> errorHandler = Map.of(
                MethodNotAllowedException.class, methodNotAllowedHandler,
                NotFoundException.class, notFoundHandler,
                ConstraintViolationException.class, constraintViolationHandler,
                WebExchangeBindException.class, webExchangeBindHandler,
                ResponseStatusException.class, responseStatusHandler,
                ReactiveFlashcardsException.class, reactiveFlashcardsHandler,
                Exception.class, genericHandler,
                JsonProcessingException.class, jsonProcessingHandler
        );

        return Mono.justOrEmpty(errorHandler.get(ex.getClass()))
                .cast(AbstractHandleException.class)
                .filter(type -> ex instanceof Exception)
                .flatMap(handler -> handler.handleException(exchange, (Exception) ex))
                .switchIfEmpty(Mono.error(ex))
                .then();
    }
}
