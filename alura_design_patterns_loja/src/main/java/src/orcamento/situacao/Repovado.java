package src.orcamento.situacao;

import src.DomainException;
import src.orcamento.Orcamento;

import java.math.BigDecimal;

public class Repovado  extends SituacaoOrcamento{

    @Override
    public void finalizar(Orcamento orcamento) {
        orcamento.setSituacao(new Finalizado());
    }
}
