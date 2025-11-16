package io.github.pedroermarinho.reactveflascards.domain.documents;

import lombok.Builder;

public record StudyCard(
        String front,
        String back
) {

    @Builder(toBuilder = true)
    public StudyCard {

    }
}
