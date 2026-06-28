package mx.florinda.pedido;

import io.quarkus.panache.common.Parameters;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.List;

@Path("/pedidos")
public class PedidoResource {

  @GET
  public Uni<List<Pedido>> lista() {
    return Pedido.find("SELECT DISTINCT p FROM Pedido p LEFT JOIN FETCH p.itensPedido").list();
  }

  @GET
  @Path("/{id}")
  public Uni<Pedido> porId(Long id) {
    return Pedido.find("FROM Pedido p LEFT JOIN FETCH p.itensPedido WHERE p.id = :id", Parameters.with("id", id))
            .firstResult();
  }

}
