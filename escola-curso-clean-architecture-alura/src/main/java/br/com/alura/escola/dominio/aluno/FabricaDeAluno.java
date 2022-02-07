package br.com.alura.escola.dominio.aluno;

public class FabricaDeAluno {

    private Aluno aluno;

    public FabricaDeAluno comNomeCpfEmail(String nome, String cpf, String email){
        this.aluno= new Aluno(new CPF(cpf), nome, new Email(email));
        return this;
    }

    public FabricaDeAluno comTelefone(String ddd, String numero){
        this.aluno.adicionarTelefone(ddd,numero);
        return this;
    }

    public br.com.alura.escola.dominio.aluno.Aluno criar() {
        return aluno;
    }
}
