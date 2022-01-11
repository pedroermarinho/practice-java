package src.orcamento;

import src.orcamento.situacao.EmAnalise;
import src.orcamento.situacao.Finalizado;
import src.orcamento.situacao.SituacaoOrcamento;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Orcamento implements Orcavel{

    private BigDecimal valor;
    private SituacaoOrcamento situacao;
    private final List<Orcavel> itens;

    public Orcamento() {
        this.valor = BigDecimal.ZERO;
        this.itens = new ArrayList<>();
        this.situacao = new EmAnalise();
    }


    public void aplicarDescontoExtra(){
        BigDecimal valorDoDescontoExtra = this.situacao.calcularValorDescontoExtra(this);
        this.valor = this.valor.subtract(valorDoDescontoExtra);
    }

    public void aprovar(){
        this.situacao.aprovar(this);
    }
    public void reprovar(){
        this.situacao.reprovar(this);
    }

    public  void finalizar(){
        this.situacao.finalizar(this);
    }

    public BigDecimal getValor() {
        return valor;
    }

    public List<Orcavel> getItens() {
        return itens;
    }

    public void addItem(Orcavel orcavel) {
        this.valor = valor.add(orcavel.getValor());
        this.itens.add(orcavel);
    }

    public int getQuantidadeItens(){
        return itens.size();
    }

    public SituacaoOrcamento getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoOrcamento situacao) {
        this.situacao = situacao;
    }

    public boolean isFinalizado() {
        return situacao instanceof Finalizado;
    }
}
