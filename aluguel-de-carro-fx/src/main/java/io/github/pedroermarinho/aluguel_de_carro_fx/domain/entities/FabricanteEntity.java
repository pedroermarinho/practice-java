package io.github.pedroermarinho.aluguel_de_carro_fx.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class FabricanteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String cnpj;

    private String nome;

    @OneToMany(mappedBy = "fabricante")
    private List<ModeloEntity> modeloEntities = new ArrayList<>();

    public FabricanteEntity(String cnpj, String nome) {
        this.cnpj = cnpj;
        this.nome = nome;
    }

    public FabricanteEntity() {
    }
}
