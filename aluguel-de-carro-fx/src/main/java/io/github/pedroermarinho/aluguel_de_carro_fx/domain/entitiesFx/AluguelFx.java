package io.github.pedroermarinho.aluguel_de_carro_fx.domain.entitiesFx;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class AluguelFx {

    private SimpleDoubleProperty valor;

    private SimpleIntegerProperty dias;

    private SimpleBooleanProperty status;

    private SimpleStringProperty devolucao;

    private SimpleStringProperty entrega;

    public AluguelFx(Double valor, Integer dias, Boolean status, String devolucao, String entrega) {
        this.valor = new SimpleDoubleProperty(valor);
        this.dias = new SimpleIntegerProperty(dias);
        this.status = new SimpleBooleanProperty(status);
        this.devolucao = new SimpleStringProperty(devolucao);
        this.entrega = new SimpleStringProperty(entrega);
    }

    public double getValor() {
        return valor.get();
    }

    public SimpleDoubleProperty valorProperty() {
        return valor;
    }

    public int getDias() {
        return dias.get();
    }

    public SimpleIntegerProperty diasProperty() {
        return dias;
    }

    public boolean isStatus() {
        return status.get();
    }

    public SimpleBooleanProperty statusProperty() {
        return status;
    }

    public String getDevolucao() {
        return devolucao.get();
    }

    public SimpleStringProperty devolucaoProperty() {
        return devolucao;
    }

    public String getEntrega() {
        return entrega.get();
    }

    public SimpleStringProperty entregaProperty() {
        return entrega;
    }
}
