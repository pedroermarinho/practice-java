package src;

import src.imposto.CalculadoraDeImposto;
import src.imposto.ICMS;
import src.imposto.ISS;
import src.orcamento.Orcamento;

import java.math.BigDecimal;

public class TestesImpostos {

    public static void main(String[] args) {
        Orcamento orcamento = new Orcamento(new BigDecimal("100"));
        CalculadoraDeImposto calculadoraDeImposto = new CalculadoraDeImposto();

        System.out.println(calculadoraDeImposto.calcular(orcamento, new ICMS()));
    }
}
