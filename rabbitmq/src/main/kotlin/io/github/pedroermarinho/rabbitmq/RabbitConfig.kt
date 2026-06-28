package io.github.pedroermarinho.rabbitmq

import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.DefaultClassMapper
import org.springframework.amqp.support.converter.DefaultJackson2JavaTypeMapper
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class RabbitConfig {

    @Bean
    fun jsonConverter(): Jackson2JsonMessageConverter {
        val converter = Jackson2JsonMessageConverter()
        val classMapper = DefaultClassMapper()
        classMapper.setTrustedPackages("io.github.pedroermarinho.rabbitmq")
        converter.setClassMapper(classMapper)
        return converter
    }

    @Bean
    fun rabbitTemplate(cf: ConnectionFactory, conv: Jackson2JsonMessageConverter): RabbitTemplate {
        val t = RabbitTemplate(cf)
        t.messageConverter = conv
        t.setMandatory(true)
        t.setConfirmCallback { correlationData, ack, cause ->
            if (!ack) {
                println("NACK do broker para {}: {}\", correlation, cause")
            }
        }

        t.setReturnsCallback { returnedMessage ->
            println(
                "Mensagem não roteável: rk={} reply={}".format(
                    returnedMessage.routingKey,
                    returnedMessage.replyText
                )
            )
        }
        return t
    }


}