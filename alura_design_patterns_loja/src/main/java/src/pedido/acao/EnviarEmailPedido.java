package src.pedido.acao;

import src.pedido.GeraPedido;
import src.pedido.Pedido;

public class EnviarEmailPedido implements  AcaoAposGerarPedido{

    @Override
    public void execute(Pedido pedido) {
        System.out.println("Enviando email com dados do pedido");
    }
}
