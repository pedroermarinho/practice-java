package src.pedido;

import src.orcamento.Orcamento;

import java.time.LocalDateTime;

public class GeraPedidoHandler {


    public void execute(GeraPedido dados){
        final Orcamento orcamento= new Orcamento(dados.getValorOrcamento(),dados.getQuantidadeItens());

        final Pedido pedido = new Pedido(dados.getCliente(), LocalDateTime.now(),orcamento);

        System.out.println("Salvar pedido no Banco de Dados");
        System.out.println("Enviar email com dados do novo pedido");
    }

}
