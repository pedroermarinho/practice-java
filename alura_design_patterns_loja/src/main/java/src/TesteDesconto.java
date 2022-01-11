package src;

import src.desconto.CalculadoraDeDesconto;
import src.orcamento.ItemOrcamento;
import src.orcamento.Orcamento;

import java.math.BigDecimal;

public class TesteDesconto {
    public static void main(String[] args) {
        Orcamento orcamento = new Orcamento();
        orcamento.finalizar();
        orcamento.addItem(new ItemOrcamento(new BigDecimal("1000")));

        CalculadoraDeDesconto calculadora = new CalculadoraDeDesconto();

        System.out.println(calculadora.calcular(orcamento));
    }
}
