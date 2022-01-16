package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {
    BonusService bonusService;

    @BeforeEach
    void inicializar(){
        this.bonusService = new BonusService();
    }

    @Test
    void bonusDeveriaSerZeroParaFuncicionarioComSalarioMuitoAlto(){

        final Funcionario funcionario = new Funcionario("teste", LocalDate.now(),new BigDecimal("25000"));
        assertThrows(IllegalArgumentException.class, ()->this.bonusService.calcularBonus(funcionario));
    }

    @Test
    void bonusDeveriaSer10PorCentoDoSalario(){
        final Funcionario funcionario = new Funcionario("teste", LocalDate.now(),new BigDecimal("2500"));
        final BigDecimal bonus = this.bonusService.calcularBonus(funcionario);
        assertEquals(bonus,new BigDecimal("250.00"));
    }
    @Test
    void bonusDeveriaSer10PorCentoParaSalarioDeExatamente10000(){
        final Funcionario funcionario = new Funcionario("teste", LocalDate.now(),new BigDecimal("10000"));
        final BigDecimal bonus = this.bonusService.calcularBonus(funcionario);
        assertEquals(bonus,new BigDecimal("1000.00"));
    }

}