package br.com.alura.rh.service.promocao;

import br.com.alura.rh.model.Cargo;
import br.com.alura.rh.model.Funcionario;

public interface ValidacaoPromover {

    public void validar(Funcionario funcionario,boolean metaBatida);
}
