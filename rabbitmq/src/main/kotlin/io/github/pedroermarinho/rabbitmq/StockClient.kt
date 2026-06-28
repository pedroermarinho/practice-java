package io.github.pedroermarinho.rabbitmq

import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Service

@Service
class StockClient(
    private val rabbit: RabbitTemplate,
) {

    init {
        rabbit.setReplyTimeout(3000)
    }


    fun isAvailable(sku: String, quantity: Int): Boolean{
        val stockReply: StockReply? = rabbit.convertSendAndReceive(
            RabbitTopology.RPC_EXCHANGE,
            RabbitTopology.RPC_RK,
            StockRequest(sku, quantity)
        ) as StockReply?

        if (stockReply == null){
            throw IllegalArgumentException("Timeout no RPC de estoque")
        }

        return stockReply.available
    }
}