package io.github.pedroermarinho;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CountDownLatchSistemaLoteApp {

    static void main() throws ExecutionException, InterruptedException {

        CountDownLatch latch = new CountDownLatch(2);

        ExecutorService executor = Executors.newFixedThreadPool(1);

        List<Future<String>> resultados = new ArrayList<>();

        IO.println("Iniciando SistemaLoteApp");


        for (int i = 1; i <= 6; i++) {
            ProcessadorArquivo tarefa = new ProcessadorArquivo("arquivo_transacoes_" + i + ".csv", latch);
            Future<String> futuroResultado = executor.submit(tarefa);
            resultados.add(futuroResultado);
        }

        IO.println("Esperando latch");
        latch.await();
        IO.println("latch finalizado");

        executor.shutdown();

        System.out.println("\n☕ Threads trabalhando de forma concorrente. Vamos coletar os resultados...\n");

        for (Future<String> resultado : resultados) {
            String relatorio = resultado.get();
            IO.println(relatorio);
        }

        System.out.println("\n🏁 Todos os arquivos foram processados com sucesso!");
    }

}
