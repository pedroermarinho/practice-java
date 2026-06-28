package io.github.pedroermarinho;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GeradorCSV {

    static void main() {
        for (int i = 1; i <= 6; i++) {
            String nomeArquivo = "arquivo_transacoes_" + i + ".csv";

            try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
                // Escreve o cabeçalho do CSV
                writer.println("id,cliente,valor,status");

                // Gera 100 linhas de dados fictícios por arquivo
                for (int j = 1; j <= 100; j++) {
                    String cliente = "Cliente_" + j;
                    double valor = Math.round((Math.random() * 5000) * 100.0) / 100.0;
                    String status = (Math.random() > 0.1) ? "APROVADO" : "REJEITADO";

                    writer.printf("%d,%s,%.2f,%s%n", j, cliente, valor, status);
                }

                System.out.println("💾 Arquivo criado: " + nomeArquivo);

            } catch (IOException e) {
                System.err.println("Erro ao gerar o arquivo " + nomeArquivo + ": " + e.getMessage());
            }
        }
    }
}
