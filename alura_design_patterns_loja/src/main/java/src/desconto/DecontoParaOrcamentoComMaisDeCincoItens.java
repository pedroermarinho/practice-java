package src.desconto;

import src.orcamento.Orcamento;

import java.math.BigDecimal;

public class DecontoParaOrcamentoComMaisDeCincoItens extends Desconto {

    public DecontoParaOrcamentoComMaisDeCincoItens(Desconto proximo) {
        super(proximo);
    }

    @Override
    protected BigDecimal efetuarCalculo(Orcamento orcamento){
        return orcamento.getValor().multiply(new BigDecimal("0.1"));
    }

    @Override
    protected boolean deveAplicar(Orcamento orcamento) {
        return orcamento.getQuantidadeItens()>5;
    }


}
