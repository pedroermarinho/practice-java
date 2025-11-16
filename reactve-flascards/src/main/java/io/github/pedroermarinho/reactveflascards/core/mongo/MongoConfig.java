package io.github.pedroermarinho.reactveflascards.core.mongo;


import io.github.pedroermarinho.reactveflascards.core.mongo.converter.DateToOffsetDateTimeConverter;
import io.github.pedroermarinho.reactveflascards.core.mongo.converter.OffsetDateTimeToDateConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableMongoAuditing(dateTimeProviderRef = "dateTimeProvider")
public class MongoConfig {


    @Bean
    MongoCustomConversions mongoCustomConversions(){
        final List<Converter<?,?>> converters = new ArrayList<>();
        converters.add(new DateToOffsetDateTimeConverter());
        converters.add(new OffsetDateTimeToDateConverter());
        return new MongoCustomConversions(converters);
    }
}
