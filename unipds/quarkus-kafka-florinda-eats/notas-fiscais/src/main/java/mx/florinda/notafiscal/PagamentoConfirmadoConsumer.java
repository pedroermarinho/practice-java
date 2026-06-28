package mx.florinda.notafiscal;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class PagamentoConfirmadoConsumer {

    @RestClient
    PedidoService pedidoService;

    @Incoming("pagamentosConfirmados")
    public Uni<Void> consume(PagamentoConfirmadoEvent event) {
        return pedidoService.notaFiscal(event.pedidoId, event.valor).onItem().invoke(notaFiscal -> {
            System.out.println("Nota Fiscal Gerada:");
            System.out.println(notaFiscal);
        }).replaceWithVoid();
    }

}
