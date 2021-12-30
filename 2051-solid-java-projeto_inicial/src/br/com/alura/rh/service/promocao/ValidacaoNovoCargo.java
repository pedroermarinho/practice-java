package br.com.alura.rh.service.promocao;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Cargo;
import br.com.alura.rh.model.Funcionario;

public class ValidacaoNovoCargo implements ValidacaoPromover{
    @Override
    public void validar(Funcionario funcionario, boolean metaBatida) {
        final Cargo cargoAtual = funcionario.getCargo();

        if(Cargo.GERENTE == cargoAtual){
            throw new ValidacaoException("Gerente não podem ser promovidos!");
        }
    }
}
