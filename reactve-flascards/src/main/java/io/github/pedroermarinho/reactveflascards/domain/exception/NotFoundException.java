package io.github.pedroermarinho.reactveflascards.domain.exception;

public class NotFoundException extends ReactiveFlashcardsException{
    public NotFoundException(String message) {
        super(message);
    }
}
