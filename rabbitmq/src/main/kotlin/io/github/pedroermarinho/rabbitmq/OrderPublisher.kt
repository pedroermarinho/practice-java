package io.github.pedroermarinho.rabbitmq

import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Service

@Service
class OrderPublisher(
    private val rabbitTemplate: RabbitTemplate,
) {

    fun publishCreated(event: OrderCreated): Unit {
        rabbitTemplate.convertAndSend(
            RabbitTopology.EXCHANGE,
            RabbitTopology.RK_ORDER_CREATED,
            event
        ) {
            it.messageProperties.messageId = event.id
            it.messageProperties.contentType = "application/json"
            it
        }
    }
}