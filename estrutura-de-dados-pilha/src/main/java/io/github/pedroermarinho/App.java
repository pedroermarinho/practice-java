package io.github.pedroermarinho;

import java.util.Stack;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        final Pilha pilha = new Pilha();

        pilha.insere("mauricio");
        System.out.println(pilha);

        pilha.insere("Guilherme");
        System.out.println(pilha);

        System.out.println(pilha.remove());
        System.out.println(pilha);

        System.out.println(pilha.remove());
        System.out.println(pilha);

        System.out.println(pilha.vazia());

        pilha.insere("Marcelo");
        System.out.println(pilha);

        System.out.println(pilha.vazia());

        System.out.println("--------------------------");

        final Stack<String> stack = new Stack<>();

        stack.push("Mauricio");
        stack.push("Marcelo");

        System.out.println(stack);

        System.out.println(stack.pop());

        System.out.println(stack);

        System.out.println(stack.peek());

        System.out.println(stack);
    }
}
