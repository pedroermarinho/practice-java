package src.imposto;

import src.orcamento.Orcamento;

import java.math.BigDecimal;

public abstract class Imposto {

    private final Imposto outro;

    protected Imposto(Imposto outro) {
        this.outro = outro;
    }

    protected abstract BigDecimal realizarCalculo(Orcamento orcamento);

    public BigDecimal calcular(Orcamento orcamento){
        final BigDecimal valorImposto = realizarCalculo(orcamento);
        final BigDecimal valorDoOutroImposo = outro == null? BigDecimal.ZERO:outro.realizarCalculo(orcamento);

        return valorImposto.add(valorDoOutroImposo);
    }
}
