package io.github.pedroermarinho.rabbitmq

import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.amqp.support.AmqpHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap

@Component
class NotificationWorker {

    val processed: MutableSet<String> = ConcurrentHashMap.newKeySet()

    @RabbitListener(queues = [RabbitTopology.NOTIFICATION_Q])
    fun onOrderCreated(
        event: OrderCreated,
        @Header(AmqpHeaders.MESSAGE_ID)
        messageId: String
    ): Unit {

        if (event.id.startsWith("FAIL")){
            throw IllegalArgumentException("Falha simulada para " + event.id)
        }

        if (!processed.add(messageId)){
            println("Duplicata ignorada:$messageId")
            return
        }

        println("Enviando e-mail do pedido ${event.id} (msgId=$messageId)")
    }
}