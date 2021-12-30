package src.imposto;

import src.orcamento.Orcamento;

import java.math.BigDecimal;

public class ICMS implements TipoImposto {

    @Override
    public BigDecimal calcular(Orcamento orcamento){
        return  orcamento.getValor().multiply(new BigDecimal("0.1"));
    }

}
