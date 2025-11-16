package io.github.pedroermarinho.reactveflascards.core.validation;

import io.netty.util.internal.StringUtil;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;


@Slf4j
public class MonoIdValidator implements ConstraintValidator<MongoId, String> {
    @Override
    public void initialize(MongoId constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        log.info("Validating MongoId: {}", value);
        return !StringUtil.isNullOrEmpty(value) && ObjectId.isValid(value);
    }
}
