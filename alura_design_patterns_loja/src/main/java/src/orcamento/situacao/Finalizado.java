package src.orcamento.situacao;

import src.orcamento.Orcamento;

import java.math.BigDecimal;

public class Repovado {
    public BigDecimal calcularValorDescontoExtra(Orcamento orcamento){
        return orcamento.getValor().multiply(new BigDecimal("0.05"));
    }

    public void aprovar(Orcamento orcamento){
        orcamento.setSituacao(new Aprovado());
    }

    public void emAnalise(Orcamento orcamento){
        orcamento.setSituacao(new EmAnalise());
    }

}
