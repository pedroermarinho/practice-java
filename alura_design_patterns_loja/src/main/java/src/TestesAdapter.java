package src;

import src.http.JavaHttpClient;
import src.orcamento.ItemOrcamento;
import src.orcamento.Orcamento;
import src.orcamento.RegistroDeOrcamento;

import java.math.BigDecimal;

public class TestesAdapter {
    public static void main(String[] args) {

        final Orcamento orcamento = new Orcamento();
        orcamento.addItem(new ItemOrcamento(BigDecimal.TEN));
        orcamento.aprovar();
        orcamento.finalizar();

        final RegistroDeOrcamento registroDeOrcamento = new RegistroDeOrcamento(new JavaHttpClient());

        registroDeOrcamento.registrar(orcamento);
    }
}
