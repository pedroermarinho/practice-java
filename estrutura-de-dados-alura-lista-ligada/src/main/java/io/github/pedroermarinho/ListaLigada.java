package io.github.pedroermarinho;

public class ListaLigada {

    private Celula primeira = null;
    private Celula ultimo = null;
    private int totalDeElemento = 0;

    public void adiocionarNoComeco(Object elemento) {
        final Celula nova = new Celula(elemento);

        if(this.totalDeElemento == 0){
            this.primeira = nova;
            this.ultimo = nova;
        }else {
            nova.setProximo(this.primeira);
            this.primeira.setAnterior(nova);
            this.primeira = nova;

        }

        totalDeElemento++;
    }

    public void adicionar(Object elemento) {
        if (this.totalDeElemento == 0){
            adiocionarNoComeco(elemento);
        }else {
            final Celula nova = new Celula(elemento);
            this.ultimo.setProximo(nova);
            nova.setAnterior(this.ultimo);
            this.ultimo = nova;
            this.totalDeElemento++;

        }
    }

    public void adicionar(int posicao, Object elemento){
        if (posicao==0){
            adiocionarNoComeco(elemento);
        }else if (posicao==this.totalDeElemento){
            adicionar(elemento);
        }else {
            final Celula anterior = this.pegaCelula(posicao-1);
            final Celula proxima = anterior.getProximo();
            final Celula nova = new Celula(elemento,anterior.getProximo());

            nova.setAnterior(anterior);
            anterior.setProximo(nova);
            nova.setProximo(proxima);
            this.totalDeElemento++;
        }
    }

    public Object pegar(int posicao) {
        return this.pegaCelula(posicao).getElemento();
    }

    public void removeDoComeco(){
        if (this.totalDeElemento==0){
            throw new IllegalArgumentException("Lista vazia");
        }

        this.primeira = this.primeira.getProximo();
        this.totalDeElemento--;

        if(this.totalDeElemento == 0){
            this.ultimo = null;
        }
    }

    public void  removeDoFim(){
        if (this.totalDeElemento==1){
            this.removeDoComeco();
        }else{
            final Celula penultima = this.ultimo.getAnterior();
            penultima.setProximo(null);
            this.ultimo=penultima;
            this.totalDeElemento --;
        }
    }

    public void remove(int posicao) {
        if (posicao==0){
            this.removeDoComeco();
        }else if (posicao == this.totalDeElemento-1) {
            this.removeDoFim();
        }else {
            final Celula anterior =  this.pegaCelula(posicao-1);
            final Celula atual =anterior.getProximo();
            final Celula proximo = atual.getProximo();

            anterior.setProximo(proximo);
            proximo.setAnterior(anterior);

            this.totalDeElemento--;
        }
    }


    public int tamanho() {
        return totalDeElemento;
    }

    public boolean contem(Object elemento) {
        Celula atual = this.primeira;

        while (atual!=null){
            if (atual.getElemento().equals(elemento)){
                return true;
            }
            atual= atual.getProximo();
        }
        return false;
    }

    @Override
    public String toString() {

        if(this.totalDeElemento == 0){
            return "[]";
        }

        Celula atual = this.primeira;

        final StringBuilder builder = new StringBuilder(this.totalDeElemento+" -> [");

        for (int i = 0; i < this.totalDeElemento; i++) {
            builder.append(atual.getElemento());
            builder.append(",");

            atual = atual.getProximo();
        }

        builder.append("]");

        return builder.toString();
    }

    private boolean posicaoOcupada(int posicao){
        return posicao>= 0 && posicao< this.totalDeElemento;
    }

    private Celula pegaCelula(int posicao){
        if(!posicaoOcupada(posicao)){
            throw new IllegalArgumentException("posição inexistente");
        }

        Celula atual = primeira;

        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }

        return atual;
    }
}
