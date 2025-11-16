package io.github.pedroermarinho.reactveflascards.domain.documents;

import lombok.Builder;

public record Question(
        String asked,
        String answered,
        String expected
) {

    @Builder(toBuilder = true)
    public Question {

    }
}
