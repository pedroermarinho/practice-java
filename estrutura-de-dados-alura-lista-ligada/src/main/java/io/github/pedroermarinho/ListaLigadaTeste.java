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

        lista.adicionar(2,"Gabriel");
        System.out.println(lista);

        Object x = lista.pegar(2);
        System.out.println(x);

        System.out.println(lista.tamanho());

        lista.removeDoComeco();
        System.out.println(lista);

        lista.removeDoFim();
        System.out.println(lista);

        lista.adicionar("Jose");
        lista.adicionar("Joao");
        System.out.println(lista);

        lista.remove(2);
        System.out.println(lista);

        System.out.println(lista.contem("Joao"));
        System.out.println(lista.contem("maria"));

    }
}
