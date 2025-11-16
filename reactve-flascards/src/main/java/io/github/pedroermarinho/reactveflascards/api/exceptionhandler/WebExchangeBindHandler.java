package io.github.pedroermarinho.reactveflascards.api.exceptionhandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.pedroermarinho.reactveflascards.api.controller.response.ErrorFieldResponse;
import io.github.pedroermarinho.reactveflascards.api.controller.response.ProblemResponse;
import io.github.pedroermarinho.reactveflascards.domain.exception.BaseErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class WebExchangeBindHandler  extends AbstractHandleException<WebExchangeBindException>{


    private final MessageSource messageSource;
    public WebExchangeBindHandler(ObjectMapper objectMapper, MessageSource messageSource) {
        super(objectMapper);
        this.messageSource = messageSource;
    }

    @Override
    Mono<Void> handleException(ServerWebExchange exchange, WebExchangeBindException ex) {
        return Mono.fromCallable(() -> {
                    prepareExchege(exchange, HttpStatus.INTERNAL_SERVER_ERROR);
                    return BaseErrorMessage.GENERIC_EXCEPTION.getMessage();
                }).map(message -> buildError(HttpStatus.INTERNAL_SERVER_ERROR, message))
                .flatMap(response -> buildParamErrorMessage(response, ex))
                .doFirst(() -> log.error("==== WebExchangeBindException:", ex))
                .flatMap(problemResponse -> writeResponse(exchange, problemResponse));
    }

    private Mono<ProblemResponse> buildParamErrorMessage(final ProblemResponse response, final WebExchangeBindException ex) {
        return Flux.fromIterable(ex.getAllErrors())
                .map(objectError -> ErrorFieldResponse.builder()
                        .name(objectError instanceof FieldError ? ((FieldError) objectError).getField() : objectError.getObjectName())
                        .message(messageSource.getMessage(objectError, LocaleContextHolder.getLocale()))
                        .build())
                .collectList()
                .map(problems -> response.toBuilder().errors(problems).build());
    }
}
