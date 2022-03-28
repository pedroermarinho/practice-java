package io.github.pedroermarinho;

public class Celula {

    private final Object elemento;
    private Celula proximo;
    private Celula anterior;

    public Celula(Object elemento, Celula proximo) {
        this.elemento = elemento;
        this.proximo = proximo;
    }

    public Celula(Object elemento) {
        this.elemento = elemento;
    }

    public Object getElemento() {
        return elemento;
    }

    public Celula getProximo() {
        return proximo;
    }

    public void setProximo(Celula proximo) {
        this.proximo = proximo;
    }

    public Celula getAnterior() {
        return anterior;
    }

    public void setAnterior(Celula anterior) {
        this.anterior = anterior;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((elemento == null) ? 0 : elemento.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Celula other = (Celula) obj;
        if (elemento == null) {
            return other.elemento == null;
        } else return elemento.equals(other.elemento);
    }

    @Override
    public String toString() {
        return anterior + "<-((" + elemento + "))->" + proximo;
    }


}
