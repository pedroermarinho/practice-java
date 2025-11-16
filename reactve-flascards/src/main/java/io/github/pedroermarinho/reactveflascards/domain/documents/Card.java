package io.github.pedroermarinho.reactveflascards.domain.documents;

import lombok.Builder;

public record Card(
        String front,
        String back
) {

    @Builder(toBuilder = true)
    public Card {

    }
}
