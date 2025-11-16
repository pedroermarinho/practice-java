package io.github.pedroermarinho.reactveflascards.domain.repository;


import io.github.pedroermarinho.reactveflascards.domain.documents.UserDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ReactiveMongoRepository<UserDocument,String> {
}
