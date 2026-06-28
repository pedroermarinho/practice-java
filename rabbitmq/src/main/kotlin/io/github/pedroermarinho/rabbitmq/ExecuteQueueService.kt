package io.github.pedroermarinho.rabbitmq

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Service
import java.util.UUID

//@Service
class ExecuteQueueService(
    private val orderPublisher: OrderPublisher
): CommandLineRunner {
    override fun run(vararg args: String?) {
        var atomicId = 0;

        while (true) {

            Thread.sleep(500)

            if (atomicId % 5 == 0){
                val teste = OrderCreated(
                    id = "FAIL" + UUID.randomUUID().toString(),
                    name = "FAIL Teste ${atomicId++}",
                )

                orderPublisher.publishCreated(teste)
                continue
            }


            val teste = OrderCreated(
                id = UUID.randomUUID().toString(),
                name = "Teste ${atomicId++}",
            )

            orderPublisher.publishCreated(teste)
            orderPublisher.publishCreated(teste)
        }

    }
}