package mx.florinda.notafiscal;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.math.BigDecimal;

@Path("/nota-fiscal")
public class NotaFiscalResource {

  @RestClient
  PedidoService pedidoService;

  @GET
  @Path("/pedido/{pedidoId}")
  public Uni<String> porId(@PathParam("pedidoId") Long pedidoId) {
    return pedidoService.notaFiscal(pedidoId, new BigDecimal("9.99"));
  }

}
