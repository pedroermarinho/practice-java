package io.github.pedroermarinho.aluguel_de_carro_fx.domain.entitiesFx;

import javafx.beans.property.SimpleStringProperty;

public class AtendenteFx {

    private final SimpleStringProperty nome;

    private final SimpleStringProperty login;

    public AtendenteFx(String nome, String login) {
        this.nome = new SimpleStringProperty(nome);
        this.login =new SimpleStringProperty( login);
    }

    public String getNome() {
        return nome.get();
    }

    public SimpleStringProperty nomeProperty() {
        return nome;
    }

    public String getLogin() {
        return login.get();
    }

    public SimpleStringProperty loginProperty() {
        return login;
    }
}
