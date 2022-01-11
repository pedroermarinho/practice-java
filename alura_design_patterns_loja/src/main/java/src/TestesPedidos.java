package src;


import src.pedido.GeraPedido;
import src.pedido.GeraPedidoHandler;
import src.pedido.acao.EnviarEmailPedido;
import src.pedido.acao.LogDePedido;
import src.pedido.acao.SalvarPedidoNoBancoDeDados;

import java.math.BigDecimal;
import java.util.Arrays;

public class TestesPedidos {

    public static void main(String[] args) {
        final String cliente = "teste";
        final BigDecimal valorOrcamento = new BigDecimal("100");
        final int quantidade =4;

        final GeraPedido gerador = new GeraPedido(cliente,valorOrcamento,quantidade);
        final GeraPedidoHandler handler = new GeraPedidoHandler(
                Arrays.asList(
                        new SalvarPedidoNoBancoDeDados(),
                        new EnviarEmailPedido(),
                        new LogDePedido()
                )
        );
        handler.execute(gerador);

    }
}
