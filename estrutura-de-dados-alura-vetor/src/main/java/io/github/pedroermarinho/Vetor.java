package io.github.pedroermarinho;

import java.util.Arrays;

public class Vetor {

    private Aluno[] alunos = new Aluno[2];
    private int totalDeAlunos = 0;


    private void garanteEspaço(){
        if(this.totalDeAlunos == alunos.length){
            final Aluno[] novoArray =  new Aluno[alunos.length*2];
            for (int i = 0; i < alunos.length; i++) {
                novoArray[i]= this.alunos[i];
            }
            this.alunos = novoArray;
        }
    }


    public void adicionar(Aluno aluno){
        garanteEspaço();
        this.alunos[this.totalDeAlunos] =aluno;
        this.totalDeAlunos ++;
    }

    private boolean posiscaoValida(int posicao){
        return posicao>=0 && posicao<= totalDeAlunos;
    }

    public void adicionar(int posicao, Aluno aluno){

        garanteEspaço();

        if(!posiscaoValida(posicao)){
            throw new IllegalArgumentException("posição invalida");
        }

        for (int i = totalDeAlunos; i>= posicao; i--){
            this.alunos[i+1] = this.alunos[i];
        }
        this.alunos[posicao] = aluno;
        totalDeAlunos++;

    }

    private boolean posicacaoOcupada(int posicao){
        return posicao >= 0 && posicao< totalDeAlunos;
    }

    public Aluno pega(int posicao){

        if(!posicacaoOcupada(posicao)){
            throw new IllegalArgumentException("posição invalida");
        }

        return alunos[posicao];
    }

    public void remove(int posicao){
        for (int i = posicao; i < this.totalDeAlunos ; i++) {
           this.alunos[i] = this.alunos[i+1];
        }
        totalDeAlunos--;
    }

    public boolean contem(Aluno aluno){

        for (int i=0; i< totalDeAlunos; i ++){
            if (aluno.equals(this.alunos[i])){
                return true;
            }
        }
        return false;
    }

    public int tamanho(){
        return totalDeAlunos;
    }

    public String toString(){
        return Arrays.toString(alunos);
    }
}
