package br.com.alura.escola.dominio.indicacao;

import br.com.alura.escola.dominio.aluno.Aluno;

import java.time.LocalDateTime;

public class Indicacao {
    private Aluno indicado;
    private Aluno indicante;
    private LocalDateTime dateIndicacao;

    public Indicacao(Aluno indicado, Aluno indicante) {
        this.indicado = indicado;
        this.indicante = indicante;
        this.dateIndicacao = LocalDateTime.now();
    }

    public Aluno getIndicado() {
        return indicado;
    }

    public Aluno getIndicante() {
        return indicante;
    }

    public LocalDateTime getDateIndicacao() {
        return dateIndicacao;
    }
}
