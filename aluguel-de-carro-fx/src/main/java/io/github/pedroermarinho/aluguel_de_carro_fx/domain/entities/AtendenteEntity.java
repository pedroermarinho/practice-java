package io.github.pedroermarinho.aluguel_de_carro_fx.domain.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class AtendenteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nome;

    @Column(unique = true, nullable = false)
    private String login;

    @Column(nullable = false)
    private String senha;

    @OneToMany(mappedBy = "atendente")
    private List<AluguelEntity> alugueis = new ArrayList<>();


    public AtendenteEntity(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public AtendenteEntity() {

    }
}
