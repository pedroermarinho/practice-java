package io.github.pedroermarinho;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutionExceptionSistemaLoteApp {

    static void main() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Future<String>> resultados = new ArrayList<>();

        IO.println("Iniciando SistemaLoteApp");

        for (int i = 1; i <= 6; i++) {
            ProcessadorArquivo tarefa = new ProcessadorArquivo("arquivo_transacoes_" + i + ".csv");
            Future<String> futuroResultado = executor.submit(tarefa);
            resultados.add(futuroResultado);
        }

        executor.shutdown();

        System.out.println("\n☕ Threads trabalhando de forma concorrente. Vamos coletar os resultados...\n");

        for (Future<String> resultado : resultados) {
            String relatorio = resultado.get();
            IO.println(relatorio);
        }

        System.out.println("\n🏁 Todos os arquivos foram processados com sucesso!");
    }

}
