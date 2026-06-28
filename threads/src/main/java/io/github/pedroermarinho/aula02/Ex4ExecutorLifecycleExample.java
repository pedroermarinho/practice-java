package io.github.pedroermarinho.aula02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Ex4ExecutorLifecycleExample {

    static void main() {


        try(ExecutorService executor = Executors.newFixedThreadPool(2)){
            executor.submit(()->{
                IO.println("Tarefa em execução");
            });
        }
        IO.println("Executor desliado via try_with_resources.");

        ExecutorService manualExecutor = Executors.newFixedThreadPool(2);

        try{
            manualExecutor.submit(()->{
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
                IO.println("Tarefa no executor manual concluida");
            });
        } finally {
            shutdownAndAwaitTermination(manualExecutor);
        }

        IO.println("Executor manual desligado");

    }

    static void shutdownAndAwaitTermination(ExecutorService pool){
        pool.shutdown();

        try{
            if (pool.awaitTermination(60, TimeUnit.SECONDS)){
                pool.shutdownNow();

                if (!pool.awaitTermination(60,TimeUnit.SECONDS)){
                    IO.println("O pool não terminou");
                }
            }
        }catch (InterruptedException e){
            pool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
