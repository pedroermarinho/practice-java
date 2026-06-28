package mx.florinda.notafiscal;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.math.BigDecimal;

@Path("/pedidos")
@RegisterRestClient
public interface PedidoService {

  @GET
  @Path("/{id}")
  Uni<PedidoDto> getById(@PathParam("id") Long pedidoId);

  default Uni<String> notaFiscal(Long pedidoId, BigDecimal valor) {
    return getById(pedidoId).onItem().transform(pedido -> """
            <xml>
              <valor>%s</valor>
              <cliente>
                <nome>%s</nome>
                <cpf>%s</cpf>
                <celular>%s</celular>
                <endereco>%s</endereco>
              </cliente>
            </xml>
            """.formatted(valor, pedido.cliente.nome, pedido.cliente.cpf, pedido.cliente.celular, pedido.cliente.endereco));
  }
}
