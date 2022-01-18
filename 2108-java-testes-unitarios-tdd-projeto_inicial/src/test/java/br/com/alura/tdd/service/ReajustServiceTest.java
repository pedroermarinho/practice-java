package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ReajustServiceTest {

    ReajusteService reajusteService;
    Funcionario funcionario;

    @BeforeEach
    void inicializar(){
        this.reajusteService= new ReajusteService();
        this.funcionario = new Funcionario("teste", LocalDate.now(),new BigDecimal("1000"));
    }

    @Test
    void reajusteDeveriaSerDe3PorcentoQuandoDesempenhoForADesejar(){
        this.reajusteService.concederReajuste(this.funcionario, Desempenho.A_DESEJAR);
        assertEquals(this.funcionario.getSalario(),new BigDecimal("1030.00"));
    }

    @Test
    void reajusteDeveriaSerDe15PorcentoQuandoDesempenhoForBom(){
        this.reajusteService.concederReajuste(this.funcionario, Desempenho.BOM);
        assertEquals(this.funcionario.getSalario(),new BigDecimal("1150.00"));
    }

    @Test
    void reajusteDeveriaSerDe20PorcentoQuandoDesempenhoForOtimo(){
        this.reajusteService.concederReajuste(this.funcionario, Desempenho.OTIMO);
        assertEquals(this.funcionario.getSalario(),new BigDecimal("1200.00"));
    }
}
