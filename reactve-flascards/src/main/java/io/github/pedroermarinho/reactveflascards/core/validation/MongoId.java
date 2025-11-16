package io.github.pedroermarinho.reactveflascards.core.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({TYPE, METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {MonoIdValidator.class})
public @interface MongoId {

    String message() default "io.github.pedroermarinho.reactveflascards.core.validation.MongoId.message";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
