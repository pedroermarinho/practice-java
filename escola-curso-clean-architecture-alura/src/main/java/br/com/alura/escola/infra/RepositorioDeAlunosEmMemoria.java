package br.com.alura.escola.infra;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.AlunoNaoEncontrado;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.dominio.aluno.RepositorioDeAlunos;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDeAlunosEmMemoria implements RepositorioDeAlunos {

    private List<Aluno> matriculados = new ArrayList<>();
    @Override
    public void matricular(Aluno aluno) {
        matriculados.add(aluno);
    }

    @Override
    public Aluno buscarPorCpf(CPF cpf) {
        return matriculados
                .stream().
                filter(
                        aluno-> aluno.getCpf().equals(cpf.getNumero())
                ).findFirst()
                .orElseThrow(()-> new AlunoNaoEncontrado(cpf));
    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        return matriculados;
    }
}
