package br.com.alura.tdd.calculadora;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {

    @Test
    public void deveriaSomarDoisNumerosPositivos(){
        final Calculadora calculadora =  new Calculadora();
        final int soma = calculadora.soma(3,7);
        Assertions.assertEquals(10,soma);
    }
}
