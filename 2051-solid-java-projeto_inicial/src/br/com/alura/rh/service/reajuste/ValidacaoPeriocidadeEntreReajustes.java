package br.com.alura.rh.service.reajuste;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ValidacaoPeriocidadeEntreReajustes implements ValidacaoReajuste {

    public void  validar(Funcionario funcionario, BigDecimal aumento){
        final LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
        final LocalDate dataAtual = LocalDate.now();

        final long mesesDeseUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste,dataAtual);

        if(mesesDeseUltimoReajuste<6){
            throw new ValidacaoException("Intervalo entre reajustes deve ser no minimo 6 meses!");
        }
    }
}
