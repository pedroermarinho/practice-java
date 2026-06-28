package mx.florinda.pagamento;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;

@Entity
public class Pagamento extends PanacheEntity {

  public BigDecimal valor;

  @Enumerated(EnumType.STRING)
  public StatusPagamento status;

  public Long pedidoId;

  @Override
  public String toString() {
    return "Pagamento{" +
            "id=" + id +
            ", pedidoId=" + pedidoId +
            ", status=" + status +
            ", valor=" + valor +
            '}';
  }
}
