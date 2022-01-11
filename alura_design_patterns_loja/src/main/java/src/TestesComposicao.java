package src;

import src.orcamento.ItemOrcamento;
import src.orcamento.Orcamento;

import java.math.BigDecimal;

public class TestesComposicao {
    public static void main(String[] args) {
        final Orcamento antigo = new Orcamento();
        antigo.addItem(new ItemOrcamento(new BigDecimal("200")));
        antigo.reprovar();

        final Orcamento novo =  new Orcamento();
        novo.addItem(new ItemOrcamento(new BigDecimal("500")));
        novo.addItem(antigo);

        System.out.println(novo.getValor());


    }
}
