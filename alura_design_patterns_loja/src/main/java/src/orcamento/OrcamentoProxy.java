package src.orcamento;

import java.math.BigDecimal;

public class OrcamentoProxy  extends  Orcamento{

    private BigDecimal valor;
    private final Orcamento orcamento;

    public OrcamentoProxy( Orcamento orcamento) {
        this.orcamento = orcamento;
    }

    @Override
    public BigDecimal getValor() {
        if(valor == null){
            this.valor = orcamento.getValor();
        }
        return valor;
    }
}
