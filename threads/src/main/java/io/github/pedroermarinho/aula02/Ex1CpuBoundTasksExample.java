package io.github.pedroermarinho.aula02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex1CpuBoundTasksExample {

    static void main() {

        int coreCount = Runtime.getRuntime().availableProcessors();
        IO.println("Numero de núcleos de CPU: "+coreCount);


        try(ExecutorService executor = Executors.newFixedThreadPool(coreCount)){


            for (int i = 0; i < coreCount * 2; i++) {
                final int taskNumber = i;

                executor.submit(()->{
                    IO.println("Iniciando tarefa CPU-bound "+taskNumber+ " em " + Thread.currentThread());
                    long result = performIntensiveCalculation();
                    IO.println("Tarefa "+ taskNumber +" concluida com resultado " + result + " em " + Thread.currentThread());
                });

            }

        }
    }


    private static long performIntensiveCalculation(){
        long sum = 0;

        for (int i = 0; i < 1_000_000_000; i++) {
            sum += i;
        }

        return sum;
    }
}
