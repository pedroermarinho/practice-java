package src;


import src.pedido.GeraPedido;
import src.pedido.GeraPedidoHandler;

import java.math.BigDecimal;

public class TestesPedidos {

    public static void main(String[] args) {
        final String cliente = args[0];
        final BigDecimal valorOrcamento = new BigDecimal(args[1]);
        final int quantidade = Integer.parseInt(args[2]);

        final GeraPedido gerador = new GeraPedido(cliente,valorOrcamento,quantidade);
        final GeraPedidoHandler handler = new GeraPedidoHandler();
        handler.execute(gerador);

    }
}
