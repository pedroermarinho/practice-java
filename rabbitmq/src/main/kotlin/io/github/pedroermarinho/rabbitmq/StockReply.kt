package io.github.pedroermarinho.rabbitmq

data class StockReply(
    val sku: String,
    val available: Boolean
)
