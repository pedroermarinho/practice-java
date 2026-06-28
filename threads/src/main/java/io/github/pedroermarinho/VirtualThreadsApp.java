package io.github.pedroermarinho;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreadsApp {

    static void main() {
        try(ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()){

            for (int i = 0; i <10_000; i++) {
                final int id = i;
                executor.submit(()->{
                    System.out.println("🧵 " + Thread.currentThread() + " | Processando lote " + id);
                    // Bloqueio pesado de I/O simulado
                    Thread.sleep(1000);
                    return id;
                });
            }

        }
    }
}
