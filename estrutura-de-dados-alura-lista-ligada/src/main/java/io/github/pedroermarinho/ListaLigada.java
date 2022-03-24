package io.github.pedroermarinho;

public class ListaLigada {

    private Celula primeira = null;
    private Celula ultimo = null;
    private int totalDeElemento = 0;

    public void adiocionarNoComeco(Object elemento) {
        final Celula novaCelula = new Celula(elemento, primeira);
        primeira = novaCelula;

        if(this.totalDeElemento==0){
            this.ultimo= this.primeira;
        }

        totalDeElemento++;
    }

    public void adicionar(Object elemento) {
        if (this.totalDeElemento == 0){
            adiocionarNoComeco(elemento);
        }else {
            final Celula nova = new Celula(elemento,null);
            this.ultimo.setProximo(nova);
            this.ultimo = nova;
            this.totalDeElemento++;
        }
    }

    private Celula pegaCelula(int posicao){

    }

    private Celula adicionar(int posicao, Object elemento){
        return null;
    }

    public Object pegar(int posicao) {
        return null;
    }

    public void remove(int posicao) {
    }

    public int tamanho() {
        return totalDeElemento;
    }

    public boolean contem(Object elemento) {
        return false;
    }

    @Override
    public String toString() {

        if(this.totalDeElemento == 0){
            return "[]";
        }

        Celula atual = this.primeira;

        final StringBuilder builder = new StringBuilder("[");

        for (int i = 0; i < this.totalDeElemento; i++) {
            builder.append(atual.getElemento());
            builder.append(",");

            atual = atual.getProximo();
        }

        builder.append("]");

        return builder.toString();
    }
}
