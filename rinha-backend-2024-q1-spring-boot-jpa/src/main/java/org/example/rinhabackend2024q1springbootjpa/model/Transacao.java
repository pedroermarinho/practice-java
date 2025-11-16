package org.example.rinhabackend2024q1springbootjpa.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transacoes")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "cliente_id")
    private Integer clienteId;
    @Column(name = "valor")
    private Integer valor;
    @Column(name = "tipo")
    private Character tipo;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "realizada_em")
    private LocalDateTime realizadaEm;

    public Transacao() {
    }

    public Transacao(Integer id, Integer clienteId, Integer valor, Character tipo, String descricao, LocalDateTime realizadaEm) {
        this.id = id;
        this.clienteId = clienteId;
        this.valor = valor;
        this.tipo = tipo;
        this.descricao = descricao;
        this.realizadaEm = realizadaEm;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getRealizadaEm() {
        return realizadaEm;
    }

    public void setRealizadaEm(LocalDateTime realizadaEm) {
        this.realizadaEm = realizadaEm;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }
}
