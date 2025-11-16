package org.example.rinhabackend2024q1springbootjpa.model;


import jakarta.persistence.*;

@Entity
@Table(name = "saldos")
public class Saldo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "limite")
    private Integer limite;
    @Column(name = "valor")
    private Integer valor;



    public Saldo(Integer id, Integer limite, Integer valor) {
        this.id = id;
        this.limite = limite;
        this.valor = valor;
    }

    public Saldo() {

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


    public Integer getLimite() {
        return limite;
    }

    public void setLimite(Integer limite) {
        this.limite = limite;
    }
}
