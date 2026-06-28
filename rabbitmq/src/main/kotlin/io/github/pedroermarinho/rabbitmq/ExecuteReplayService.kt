package io.github.pedroermarinho.rabbitmq

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ExecuteReplayService(
    private val stockClient: StockClient
): CommandLineRunner {
    override fun run(vararg args: String?) {

        println("Verificaçao de estoque")

        val result = stockClient.isAvailable("teste", 10)

        println("Resultado da verficaçao de estoque: $result")
    }
}