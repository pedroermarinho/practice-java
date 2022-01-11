package src.pedido.acao;

import src.pedido.GeraPedido;
import src.pedido.Pedido;

public interface AcaoAposGerarPedido {

    void execute(Pedido pedido);
}
