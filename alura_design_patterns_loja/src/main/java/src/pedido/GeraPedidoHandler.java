package src.pedido;

import src.orcamento.Orcamento;
import src.pedido.acao.AcaoAposGerarPedido;

import java.time.LocalDateTime;
import java.util.List;

public class GeraPedidoHandler {

    private final List<AcaoAposGerarPedido> acoes;

    public GeraPedidoHandler(List<AcaoAposGerarPedido> acoes) {
        this.acoes = acoes;
    }

    public void execute(GeraPedido dados){
        final Orcamento orcamento= new Orcamento(dados.getValorOrcamento(),dados.getQuantidadeItens());

        final Pedido pedido = new Pedido(dados.getCliente(), LocalDateTime.now(),orcamento);

        acoes.forEach(acao-> acao.execute(dados));
    }

}
