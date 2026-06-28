package io.github.pedroermarinho.rabbitmq

import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service

@Service
class StockService {


    @RabbitListener(queues = [RabbitTopology.STOCK_CHECK_Q])
    fun checkStock(req: StockRequest): StockReply {
        val available = req.quantity <= 100
        return StockReply(sku = req.sku, available = available)
    }

}