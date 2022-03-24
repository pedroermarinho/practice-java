package io.github.pedroermarinho;

/**
 * Hello world!
 *
 */
public class VetorTeste
{
    public static void main( String[] args )
    {
        final Aluno a1 =  new Aluno("joao");
        final Aluno a2 = new Aluno("Jose");

        final Vetor lista = new Vetor();

        System.out.println(lista.tamanho());

        lista.adicionar(a1);
        System.out.println(lista.tamanho());

        lista.adicionar(a2);
        System.out.println(lista.tamanho());

        System.out.println(lista);

        System.out.println(lista.contem(a1));

        final Aluno a3 = new Aluno("daniel");
        System.out.println(lista.contem(a3));

        System.out.println(lista.pega(1));
        lista.adicionar(1,a3);

        System.out.println(lista.toString());

        lista.remove(1);

        System.out.println(lista.toString());
    }
}
