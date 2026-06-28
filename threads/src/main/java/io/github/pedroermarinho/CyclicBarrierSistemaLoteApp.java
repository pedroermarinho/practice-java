package io.github.pedroermarinho;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CyclicBarrierSistemaLoteApp {

    static void main() throws ExecutionException, InterruptedException, BrokenBarrierException {
        CyclicBarrier barrier = new CyclicBarrier(3, ()->{
            System.out.println("\n📢 [Barreira] Todas as 3 threads chegaram! Liberando para a próxima fase...\n");
        });

        ExecutorService executor = Executors.newFixedThreadPool(3);

        IO.println("Iniciando SistemaLoteApp");

        for (int i = 1; i <= 20; i++) {
            final int id = i;
            executor.submit(()->{
                try{


                System.out.println("🔄 Thread " + id + ": Lendo dados do arquivo " + id + "...");
                Thread.sleep((long) (Math.random() * 2000)); // Tempos de leitura diferentes

                System.out.println("🏁 Thread " + id + ": Finalizou Fase 1 e está esperando na barreira.");
                barrier.await(5, TimeUnit.SECONDS);
                System.out.println("🚀 Thread " + id + ": Avançou para a Fase 2 (Gravação no Banco).");
                } catch (Exception e){
                    e.printStackTrace();
                }
            });

        }

        executor.shutdown();

        System.out.println("\n☕ Threads trabalhando de forma concorrente. Vamos coletar os resultados...\n");
    }

}
