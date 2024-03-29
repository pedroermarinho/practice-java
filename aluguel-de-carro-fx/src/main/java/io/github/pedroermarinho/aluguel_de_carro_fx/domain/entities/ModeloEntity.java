package io.github.pedroermarinho.aluguel_de_carro_fx.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class ModeloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ManyToOne
    private FabricanteEntity fabricante;

    @OneToMany(mappedBy = "modelo")
    private List<CarroEntity> carroEntities = new ArrayList<>();

    public ModeloEntity(String nome, FabricanteEntity fabricante) {
        this.nome = nome;
        this.fabricante = fabricante;
    }

    public ModeloEntity() {
    }
}
