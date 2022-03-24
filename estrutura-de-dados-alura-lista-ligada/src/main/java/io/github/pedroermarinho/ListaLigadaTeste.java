package io.github.pedroermarinho;

/**
 * Hello world!
 *
 */
public class ListaLigadaTeste
{
    public static void main( String[] args )
    {
        final ListaLigada lista = new ListaLigada();

        System.out.println(lista);
        
        lista.adiocionarNoComeco("maricio");
        System.out.println(lista);

        lista.adiocionarNoComeco("paulo");
        System.out.println(lista);
        
        lista.adiocionarNoComeco("guilherme");
        System.out.println(lista);


        lista.adicionar("Macelo");
        System.out.println(lista);
        
    
    }
}
