package io.github.pedroermarinho.aluguel_de_carro_fx.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class ZonaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "zona", cascade = CascadeType.ALL)
    private List<BairroEntity> bairroEntities = new ArrayList<>();

    public ZonaEntity(String nome) {
        this.nome = nome;
    }

    public ZonaEntity() {
    }
}
