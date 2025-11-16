package io.github.pedroermarinho.reactveflascards.api.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

public record UserRequest(

        @NotBlank
        @Size(min = 1, max = 255)
        @JsonProperty("name")
        String name,
        @NotBlank
        @Size(min = 1, max = 255)
        @Email
        @JsonProperty("email")
        String email
) {

    @Builder(toBuilder = true)
    public UserRequest {

    }
}
