package io.github.pedroermarinho;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserSistemaLoteApp {

    public static void main() {
        Phaser phaser = new Phaser(1);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        System.out.println("🚀 Iniciando o processamento em fases...");

        for (int i = 0; i < 3; i++) {
            final int id = i;

            phaser.register();

            executor.execute(() -> {
                try {
                    // ---- FASE 0: LEITURA ----
                    System.out.println("📂 Thread " + id + ": Lendo arquivo (Fase " + phaser.getPhase() + ")...");
                    Thread.sleep((long) (Math.random() * 1000));

                    // Avisa que chegou e aguarda os outros terminarem a leitura
                    phaser.arriveAndAwaitAdvance();

                    // ---- FASE 1: COMPACTAÇÃO ----
                    System.out.println("🗜️ Thread " + id + ": Compactando dados (Fase " + phaser.getPhase() + ")...");
                    Thread.sleep((long) (Math.random() * 1000));

                    // Finalizou o trabalho e se desregistra do phaser
                    phaser.arriveAndDeregister();
                    System.out.println("✨ Thread " + id + ": Trabalho concluído e desregistrado.");

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        phaser.arriveAndAwaitAdvance();
        System.out.println("\n📢 [Phaser] Todos os arquivos foram lidos! Iniciando próxima fase...\n");

        // Thread principal espera todas as threads terminarem a Fase 1 (Compactação) e se desregistrarem
        phaser.arriveAndAwaitAdvance();
        System.out.println("\n🏁 [Phaser] Processamento completo finalizado!");

        executor.shutdown();

    }

}
