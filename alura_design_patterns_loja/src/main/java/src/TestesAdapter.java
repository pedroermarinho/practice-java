package src;

import src.http.JavaHttpClient;
import src.orcamento.Orcamento;
import src.orcamento.RegistroDeOrcamento;

import java.math.BigDecimal;

public class TestesAdapter {
    public static void main(String[] args) {

        final Orcamento orcamento = new Orcamento(BigDecimal.TEN,1);
        orcamento.aprovar();
        orcamento.finalizar();

        final RegistroDeOrcamento registroDeOrcamento = new RegistroDeOrcamento(new JavaHttpClient());

        registroDeOrcamento.registrar(orcamento);
    }
}
