package io.github.pedroermarinho.aluguel_de_carro_fx.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class CarroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    private CorEntity cor;

    @ManyToOne
    private ModeloEntity modelo;

    @OneToMany(mappedBy = "carro")
    private List<AluguelEntity> alugueis;

}
