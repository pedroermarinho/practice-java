package io.github.pedroermarinho;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureApp {

    static void main() {

        System.out.println("🚀 [Main] Iniciando processo...");

        CompletableFuture<String> pipeline = CompletableFuture.supplyAsync(()->{
            System.out.println("📂 [Thread: " + Thread.currentThread().getName() + "] Lendo arquivo do lote...");
            simularTempo(1500);
            return "CONTEUDO_DO_ARQUIVO";
        }).thenApply(conteudo -> {
            System.out.println("🗜️ [Thread: " + Thread.currentThread().getName() + "] Processando: " + conteudo);
            return conteudo + "_PROCESSADO";
        });

        pipeline.thenAccept( resultadoFinal -> {
            System.out.println("✅ [Thread: " + Thread.currentThread().getName() + "] Salvo no banco: " + resultadoFinal);
        });

        System.out.println("☕ [Main] Thread principal está livre para fazer outras coisas...");

        pipeline.join();

        System.out.println("🏁 [Main] Fim do programa.");

    }

    private static void simularTempo(int milissegundos) {
        try { Thread.sleep(milissegundos); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
