package io.github.pedroermarinho.reactveflascards.api.mapper;

import io.github.pedroermarinho.reactveflascards.api.controller.request.UserRequest;
import io.github.pedroermarinho.reactveflascards.api.controller.response.UserResponse;
import io.github.pedroermarinho.reactveflascards.domain.documents.UserDocument;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Component
@Mapper(componentModel = "spring")
public interface UserMapper {


    UserDocument toDocument(final UserRequest request);

    UserResponse toResponse(final UserDocument document);
}
