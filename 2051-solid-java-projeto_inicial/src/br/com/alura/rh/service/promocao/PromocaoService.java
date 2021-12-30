package br.com.alura.rh.service.promocao;

import br.com.alura.rh.model.Cargo;
import br.com.alura.rh.model.Funcionario;

import java.util.List;

public class PromocaoService {

    private final List<ValidacaoPromover> validacoes;

    public PromocaoService(List<ValidacaoPromover> validacoes) {
        this.validacoes = validacoes;
    }

    public void promover(Funcionario funcionario, boolean metaBatida){

        validacoes.forEach((v)-> v.validar(funcionario,metaBatida));

        final Cargo novoCargo = funcionario.getCargo().getProximoCargo();
        funcionario.promover(novoCargo);

    }
}
