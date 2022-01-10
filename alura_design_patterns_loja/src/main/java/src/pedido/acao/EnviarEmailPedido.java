package src.pedido.acao;

import src.pedido.GeraPedido;

public class EnviarEmailPedido implements  AcaoAposGerarPedido{

    @Override
    public void execute(GeraPedido dados) {
        System.out.println("Enviando email com dados do pedido");
    }
}
