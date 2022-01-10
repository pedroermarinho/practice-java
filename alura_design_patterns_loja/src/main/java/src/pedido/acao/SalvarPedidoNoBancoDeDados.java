package src.pedido.acao;

import src.pedido.GeraPedido;

public class SalvarPedidoNoBancoDeDados implements AcaoAposGerarPedido{

    @Override
    public void execute(GeraPedido dados) {
        System.out.println("Salvar pedido no banco de dados");
    }
}
