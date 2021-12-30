package src.desconto;

import src.orcamento.Orcamento;

import java.math.BigDecimal;

public class CalculadoraDeDesconto {

    public BigDecimal calcular(Orcamento orcamento) {

        final Desconto desconto = new DecontoParaOrcamentoComMaisDeCincoItens(
                new DecontoParaOrcamentoComValorMaiorQueQuinhentos(
                        new SemDesconto()
                )
        );
        return desconto.efetuarCalculo(orcamento);
    }

}
