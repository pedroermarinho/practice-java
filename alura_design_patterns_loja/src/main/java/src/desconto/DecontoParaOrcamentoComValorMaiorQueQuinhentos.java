package src.desconto;

import src.orcamento.Orcamento;

import java.math.BigDecimal;

public class DecontoParaOrcamentoComValorMaiorQueQuinhentos extends Desconto {

    public DecontoParaOrcamentoComValorMaiorQueQuinhentos(Desconto proximo) {
        super(proximo);
    }

    public BigDecimal calcular(Orcamento orcamento){
        if(orcamento.getValor().compareTo(new BigDecimal("500"))>0){
            return orcamento.getValor().multiply(new BigDecimal("0.05"));
        }
        return  proximo.calcular(orcamento);
    }


}
