package io.github.pedroermarinho.rabbitmq

data class StockRequest(
    val sku: String,
    val quantity: Int
)
