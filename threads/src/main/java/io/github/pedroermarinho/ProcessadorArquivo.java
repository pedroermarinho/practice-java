package io.github.pedroermarinho;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class ProcessadorArquivo implements Callable<String> {

    private final String nomeArquivo;
    private final CountDownLatch latch;

    public ProcessadorArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
        this.latch = null;
    }
    public ProcessadorArquivo(String nomeArquivo,CountDownLatch latch) {
        this.nomeArquivo = nomeArquivo;
        this.latch = latch;
    }

    @Override
    public String call() throws Exception {
        System.out.println("🔄 [" + Thread.currentThread().getName() + "] Iniciando processamento do " + nomeArquivo);

        Thread.sleep(Math.min(Math.round(Math.random() * 1000),  5000));

        if (this.latch != null) {
            this.latch.countDown();
        }

        int linhasProcessadas = (int) (Math.random() * 1000) + 100; // Simula dados processados
        return "✅ " + nomeArquivo + " processado com sucesso! (" + linhasProcessadas + " linhas inseridas).";
    }
}
