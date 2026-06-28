package io.github.pedroermarinho;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class SomaLoteTask extends RecursiveTask<Long> {

    private static final int LIMITE_MAXIMO = 10000;

    private final long[] valores;
    private final int inicio;
    private final int fim;

    SomaLoteTask(long[] valores, int inicio, int fim) {
        this.valores = valores;
        this.inicio = inicio;
        this.fim = fim;
    }

    @Override
    protected Long compute() {
        IO.println("Executando Compute na thread: " + Thread.currentThread().getName());

        int tamanho = fim - inicio;

        IO.println("inicio: " + inicio + ", fim: " + fim + ", tamanho: " + tamanho);

        if (tamanho <= LIMITE_MAXIMO){
            IO.println("Menor que o limite : " + LIMITE_MAXIMO);
            long soma = 0;
            for (int i = inicio; i <fim; i++) {
               soma += valores[i];
            }
            return soma;
        }

        int meio = inicio + (tamanho / 2);

        SomaLoteTask primeiraMetade = new  SomaLoteTask(valores, inicio, meio);
        SomaLoteTask segundaMetade = new  SomaLoteTask(valores, meio, fim);

        IO.println("Executando a primeira metade em paralelo");
        primeiraMetade.fork();

        IO.println("Executando a segunda metade nessa thread");
        long resultadoSegundaMetade = segundaMetade.compute();
        IO.println("Esperando pela primeira thread");
        long resultadoPrimeiraMetade = primeiraMetade.join();

        IO.println("resultado completo ");
        return resultadoPrimeiraMetade + resultadoSegundaMetade;
    }
}


public class ForkJoinSistemaLoteApp {

    static void main() {
        long [] dadosDoLote = new long[100000];

        for (int i = 0; i < dadosDoLote.length; i++) {
            dadosDoLote[i] = 1;
        }

        ForkJoinPool pool = ForkJoinPool.commonPool();

        SomaLoteTask tarefaPrincipal = new  SomaLoteTask(dadosDoLote, 0, dadosDoLote.length);

        System.out.println("⏳ Iniciando processamento pesado com ForkJoinPool...");

        long resultadoFinal = pool.invoke(tarefaPrincipal);

        System.out.println("🏁 Processamento Concluído!");
        System.out.println("📊 Total acumulado do lote: " + resultadoFinal);
    }
}
