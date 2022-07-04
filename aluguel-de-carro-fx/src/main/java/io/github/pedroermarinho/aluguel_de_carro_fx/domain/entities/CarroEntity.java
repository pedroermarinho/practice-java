package io.github.pedroermarinho.aluguel_de_carro_fx.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class CarroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    private CorEntity cor;

    @ManyToOne
    private ModeloEntity modelo;

    @OneToMany(mappedBy = "carro")
    private List<AluguelEntity> alugueis;

    public CarroEntity(CorEntity cor, ModeloEntity modelo) {
        this.cor = cor;
        this.modelo = modelo;
    }

    public CarroEntity() {
    }
}
