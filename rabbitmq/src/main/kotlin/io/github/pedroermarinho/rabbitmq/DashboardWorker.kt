package io.github.pedroermarinho.rabbitmq

import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class DashboardWorker {

    @RabbitListener(queues = [RabbitTopology.DASHBOARD_Q], concurrency = "2")
    fun onOrderCreated(orderCreated: OrderCreated) {

        Thread.sleep(500)

        if (orderCreated.id.startsWith("FAIL")){
            throw IllegalArgumentException("Falha simulada para " + orderCreated.id)
        }

        print("${Thread.currentThread().name}: painel atualizado: ${orderCreated.id}")
    }
}