package io.github.pedroermarinho.reactveflascards.api.exceptionhandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.pedroermarinho.reactveflascards.api.controller.response.ErrorFieldResponse;
import io.github.pedroermarinho.reactveflascards.api.controller.response.ProblemResponse;
import io.github.pedroermarinho.reactveflascards.domain.exception.BaseErrorMessage;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class ConstraintViolationHandler extends AbstractHandleException<ConstraintViolationException> {
    public ConstraintViolationHandler(ObjectMapper objectMapper) {
        super(objectMapper);
    }

    @Override
    Mono<Void> handleException(ServerWebExchange exchange, ConstraintViolationException ex) {
        return Mono.fromCallable(() -> {
                    prepareExchege(exchange, HttpStatus.BAD_REQUEST);
                    return BaseErrorMessage.GENERIC_BAD_REQUEST.getMessage();
                }).map(message -> buildError(HttpStatus.BAD_REQUEST, message))
                .flatMap(response -> buildParamErrorMessage(response, ex))
                .doFirst(() -> log.error("==== ConstraintViolationException:", ex))
                .flatMap(problemResponse -> writeResponse(exchange, problemResponse));
    }

    private Mono<ProblemResponse> buildParamErrorMessage(final ProblemResponse response, final ConstraintViolationException ex) {
        return Flux.fromIterable(ex.getConstraintViolations())
                .map(constraintViolation -> ErrorFieldResponse.builder()
                        .name(((PathImpl) constraintViolation.getPropertyPath()).getLeafNode().toString())
                        .message(constraintViolation.getMessage()).build())
                .collectList()
                .map(problems -> response.toBuilder().errors(problems).build());
    }
}
