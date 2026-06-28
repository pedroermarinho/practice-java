package io.github.pedroermarinho;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreSistemaLoteApp {

    static void main() {
        Semaphore semaphore = new Semaphore(2);

        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 10; i++) {
            final int idTarefa = i;

            executor.execute(()->{
                try{
                    System.out.println("🔌 Tarefa " + idTarefa + " querendo conectar na API...");

                    semaphore.acquire();

                    System.out.println("🚀 [API] Conexão ESTABELECIDA para Tarefa " + idTarefa);
                    Thread.sleep(2000); // Simula o envio de dados
                    System.out.println("✅ [API] Tarefa " + idTarefa + " finalizou o envio.");
                } catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                } finally {
                    System.out.println("🔓 Tarefa " + idTarefa + " liberou a vaga da API.");
                    semaphore.release();
                }
            });
        }
    }
}
