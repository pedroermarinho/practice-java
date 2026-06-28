package mx.florinda.pedido;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Pedido extends PanacheEntity {

  public LocalDateTime dataHora;

  @Enumerated(EnumType.STRING)
  public StatusPedido status;

  @Embedded
  public Cliente cliente;

  @OneToMany(mappedBy = "pedido")
  public List<ItemPedido> itensPedido;

  @Override
  public String toString() {
    return "Pedido{" +
            "id=" + id +
            ", status=" + status +
            '}';
  }
}
