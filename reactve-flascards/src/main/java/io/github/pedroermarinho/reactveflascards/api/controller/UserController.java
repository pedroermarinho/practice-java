package io.github.pedroermarinho.reactveflascards.api.controller;


import io.github.pedroermarinho.reactveflascards.api.controller.request.UserRequest;
import io.github.pedroermarinho.reactveflascards.api.controller.response.UserResponse;
import io.github.pedroermarinho.reactveflascards.api.mapper.UserMapper;
import io.github.pedroermarinho.reactveflascards.domain.repository.UserRepository;
import io.github.pedroermarinho.reactveflascards.domain.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Validated
@RestController
@RequestMapping("users")
@Slf4j
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<UserResponse> save(@Valid @RequestBody final UserRequest request){
        return userService.save(userMapper.toDocument(request))
                .doFirst(()-> log.info("savalvando {}", request))
                .map(userMapper::toResponse);
    }
}
