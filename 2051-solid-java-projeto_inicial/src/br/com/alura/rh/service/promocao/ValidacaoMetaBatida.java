package br.com.alura.rh.service.promocao;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

public class ValidacaoMetaBatida implements  ValidacaoPromover{
    @Override
    public void validar(Funcionario funcionario, boolean metaBatida) {
        if (!metaBatida){
            throw new ValidacaoException("Funcionario não bateu a meta!");
        }
    }
}
