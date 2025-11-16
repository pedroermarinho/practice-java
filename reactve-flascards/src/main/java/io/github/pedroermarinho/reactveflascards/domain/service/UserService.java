package io.github.pedroermarinho.reactveflascards.domain.service;


import io.github.pedroermarinho.reactveflascards.domain.documents.UserDocument;
import io.github.pedroermarinho.reactveflascards.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;


    public Mono<UserDocument> save(UserDocument userDocument) {
        return userRepository.save(userDocument)
                .doFirst(()-> log.info("User saved: {}", userDocument));
    }

}
