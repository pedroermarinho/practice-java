package io.github.pedroermarinho.reactveflascards.domain.documents;

import lombok.Builder;

import java.util.Set;

public record StudyDeck(
        String deckId,
        Set<StudyCard> cards
) {

    @Builder(toBuilder = true)
    public StudyDeck {

    }
}
