package src.desconto;

import src.orcamento.Orcamento;

import java.math.BigDecimal;

public class DecontoParaOrcamentoComMaisDeCincoItens extends Desconto {

    public DecontoParaOrcamentoComMaisDeCincoItens(Desconto proximo) {
        super(proximo);
    }

    public BigDecimal calcular(Orcamento orcamento){
        if (orcamento.getQuantidadeItens()>5){
            return orcamento.getValor().multiply(new BigDecimal("0.1"));
        }
        return  proximo.calcular(orcamento);
    }


}
