package src.pedido.acao;

import src.pedido.GeraPedido;
import src.pedido.Pedido;

public class LogDePedido implements  AcaoAposGerarPedido{
    @Override
    public void execute(Pedido pedido) {
        System.out.println("Pedido foi gerado: "+pedido);
    }
}
