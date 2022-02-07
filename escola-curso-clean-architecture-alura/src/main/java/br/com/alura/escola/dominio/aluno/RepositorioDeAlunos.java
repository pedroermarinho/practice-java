package br.com.alura.escola.dominio.aluno;

import java.util.List;

public interface RepositorioDeAlunos {

    void matricular(br.com.alura.escola.dominio.aluno.Aluno aluno);

    br.com.alura.escola.dominio.aluno.Aluno buscarPorCpf(br.com.alura.escola.dominio.aluno.CPF cpf);

    List<br.com.alura.escola.dominio.aluno.Aluno> listarTodosAlunosMatriculados();
}
