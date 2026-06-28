package io.github.pedroermarinho.rabbitmq

import org.springframework.amqp.core.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitTopology {

    companion object {
        const val EXCHANGE = "orders.exchange"
        const val RK_ORDER_CREATED = "orders.created"

        const val NOTIFICATION_Q = "orders.notification.q"
        const val DASHBOARD_Q = "orders.dashboard.q"

        const val DLX = "orders.dlx"
        const val NOTIFICATION_DLQ = "orders.notification.dlq"

        const val RPC_EXCHANGE = "stock.exchange"
        const val RPC_RK = "stock.check"
        const val STOCK_CHECK_Q = "stock.check.check_q"
    }

    @Bean
    fun ordersExchange(): TopicExchange {
        return ExchangeBuilder.topicExchange(EXCHANGE).durable(true).build()
    }

    @Bean
    fun deadLetterExchange(): DirectExchange {
        return ExchangeBuilder.directExchange(DLX).durable(true).build()
    }

    @Bean
    fun notificationQueue(): Queue {
        return QueueBuilder.durable(NOTIFICATION_Q)
            .deadLetterExchange(DLX)
            .deadLetterRoutingKey(NOTIFICATION_DLQ)
            .build()
    }

    @Bean
    fun notificationDLQ(): Queue {
        return QueueBuilder.durable(NOTIFICATION_DLQ).build()
    }

    @Bean
    fun dashboardQueue(): Queue {
        return QueueBuilder.durable(DASHBOARD_Q).build()
    }

    @Bean
    fun notificationBinding(): Binding {
        return BindingBuilder.bind(notificationQueue()).to(ordersExchange()).with(RK_ORDER_CREATED)
    }

    @Bean
    fun dashboardBinding(): Binding {
        return BindingBuilder.bind(dashboardQueue()).to(ordersExchange()).with(RK_ORDER_CREATED)
    }

    @Bean
    fun dlqBinding(): Binding {
        return BindingBuilder.bind(notificationDLQ()).to(deadLetterExchange()).with(NOTIFICATION_DLQ)
    }

//    RPC

    @Bean
    fun stockExchange(): DirectExchange {
        return ExchangeBuilder.directExchange(RPC_EXCHANGE).durable(true).build()
    }

    @Bean
    fun stockCheckQueue(): Queue {
        return QueueBuilder.durable(STOCK_CHECK_Q).build()
    }

    @Bean
    fun stockBinding(): Binding {
        return BindingBuilder.bind(stockCheckQueue()).to(stockExchange()).with(RPC_RK)
    }

}