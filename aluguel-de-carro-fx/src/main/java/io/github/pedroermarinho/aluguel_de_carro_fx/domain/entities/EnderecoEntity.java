package io.github.pedroermarinho.aluguel_de_carro_fx.domain.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    private ClienteEntity cliente;

    @ManyToOne
    private BairroEntity bairro;

    public EnderecoEntity( BairroEntity bairro) {
        this.cliente = null;
        this.bairro = bairro;
    }

    public EnderecoEntity() {
    }
}
