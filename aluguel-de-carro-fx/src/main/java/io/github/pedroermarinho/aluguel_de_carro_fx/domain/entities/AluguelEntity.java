package io.github.pedroermarinho.aluguel_de_carro_fx.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class AluguelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private Double valor;

    private Integer dias;

    private Boolean status;

    private LocalDate devolucao;

    private LocalDate entrega;

    @ManyToOne
    private CarroEntity carro;

    @ManyToOne
    private ClienteEntity cliente;

    @ManyToOne
    private AtendenteEntity atendente;

    public AluguelEntity(Double valor, Integer dias, Boolean status, LocalDate devolucao, LocalDate entrega, CarroEntity carro, ClienteEntity cliente, AtendenteEntity atendente) {
        this.valor = valor;
        this.dias = dias;
        this.status = status;
        this.devolucao = devolucao;
        this.entrega = entrega;
        this.carro = carro;
        this.cliente = cliente;
        this.atendente = atendente;
    }

    public AluguelEntity() {
    }
}
