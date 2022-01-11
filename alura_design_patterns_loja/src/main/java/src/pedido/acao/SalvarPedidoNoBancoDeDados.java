package src.pedido.acao;

import src.pedido.GeraPedido;
import src.pedido.Pedido;

public class SalvarPedidoNoBancoDeDados implements AcaoAposGerarPedido{

    @Override
    public void execute(Pedido pedido) {
        System.out.println("Salvar pedido no banco de dados");
    }
}
