package mx.florinda.pedido;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

@Entity
public class ItemPedido extends PanacheEntity {

  public Long quantidade;
  public BigDecimal precoUnitario;
  public String observacao;

  @JsonIgnore
  @ManyToOne
  public Pedido pedido;

  @ManyToOne
  public ItemCardapio itemCardapio;

}
