package io.github.pedroermarinho;

public class Celula {

    private Object elemento;
    private Celula proximo;

    public Celula(Object elemento, Celula proximo) {
        this.elemento = elemento;
        this.proximo = proximo;
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
            if (other.elemento != null)
                return false;
        } else if (!elemento.equals(other.elemento))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return  elemento + "->" + proximo;
    }

    
}
