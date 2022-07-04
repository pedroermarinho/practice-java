package io.github.pedroermarinho.aluguel_de_carro_fx.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
public class CorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "cor")
    private List<CarroEntity> carros = new ArrayList<>();

    public CorEntity(String nome) {
        this.nome = nome;
    }

    public CorEntity() {
    }
}
