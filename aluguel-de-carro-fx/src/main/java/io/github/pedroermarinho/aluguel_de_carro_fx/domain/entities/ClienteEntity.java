package io.github.pedroermarinho.aluguel_de_carro_fx.domain.entities;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String cnh;

    @OneToOne(mappedBy = "cliente")
    private EnderecoEntity endereco;

    @OneToMany(mappedBy = "cliente")
    private List<AluguelEntity> aluguels= new ArrayList<>();
}
