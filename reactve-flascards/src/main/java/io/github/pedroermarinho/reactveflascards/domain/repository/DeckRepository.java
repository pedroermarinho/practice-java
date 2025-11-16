package io.github.pedroermarinho.reactveflascards.domain.repository;


import io.github.pedroermarinho.reactveflascards.domain.documents.DeckDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckRepository extends ReactiveMongoRepository<DeckDocument, String> {
}
