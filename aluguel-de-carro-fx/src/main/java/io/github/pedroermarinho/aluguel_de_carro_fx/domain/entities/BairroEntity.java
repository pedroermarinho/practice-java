package io.github.pedroermarinho.aluguel_de_carro_fx.domain.entities;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class BairroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nome;

    @ManyToOne
    private ZonaEntity zona;

    @OneToMany(mappedBy = "bairro")
    private List<EnderecoEntity> enderecoEntities = new ArrayList<>();

    public BairroEntity(String nome, ZonaEntity zona) {
        this.nome = nome;
        this.zona = zona;
    }

    public BairroEntity() {
    }
}
