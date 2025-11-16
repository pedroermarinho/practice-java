package io.github.pedroermarinho.reactveflascards.domain.repository;


import io.github.pedroermarinho.reactveflascards.domain.documents.StudyDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyRepository extends ReactiveMongoRepository<StudyDocument, String> {
}
