package src.orcamento;

import src.DomainException;
import src.http.HttpAdapter;

import java.util.Map;

public class RegistroDeOrcamento {

    private final HttpAdapter http;

    public RegistroDeOrcamento(HttpAdapter http) {
        this.http = http;
    }


    public void registrar(Orcamento orcamento){

        if(!orcamento.isFinalizado()){
            throw new DomainException("Orcamento nao finalizado");
        }

        final String url = "http://api.externa/orcamento";

        Map<String, Object> dados = Map.of(
                "valor", orcamento.getValor(),
                "quantidadeItens", orcamento.getQuantidadeItens()
        );

        http.post(url,dados);
    }
}
