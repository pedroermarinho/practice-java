package io.github.pedroermarinho.reactveflascards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableReactiveMongoAuditing;

@SpringBootApplication
@EnableReactiveMongoAuditing(dateTimeProviderRef = "dateTimeProvider")
public class ReactveFlascardsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactveFlascardsApplication.class, args);
    }

}
