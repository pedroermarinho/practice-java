package io.github.pedroermarinho.aula02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Ex2IoBoundVirtualThreadsExemple {

    static void main() {
        try(ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()){

            IntStream.range(0,100_000).forEach(i->{
                executor.submit(()->{
                   try{
                       IO.println("Iniciando tarefa I/O-boud "+i+" em "+Thread.currentThread());
                       Thread.sleep(1000);
                       IO.println("Tarefa I/O-bound "+i+" concluida.");
                   }catch (InterruptedException e){
                       Thread.currentThread().interrupt();
                   }
                });
            });

        }
    }
}
