package src.imposto;

import src.orcamento.Orcamento;

import java.math.BigDecimal;

public class CalculadoraDeImposto {

    public BigDecimal calcular(Orcamento orcamento, TipoImposto imposto){
        return imposto.calcular(orcamento);
    }

}
