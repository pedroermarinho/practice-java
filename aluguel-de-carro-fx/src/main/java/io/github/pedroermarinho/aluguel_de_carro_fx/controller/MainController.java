package io.github.pedroermarinho.aluguel_de_carro_fx.controller;

import com.sun.javafx.collections.ObservableListWrapper;
import io.github.pedroermarinho.aluguel_de_carro_fx.domain.entitiesFx.AluguelFx;
import io.github.pedroermarinho.aluguel_de_carro_fx.domain.entitiesFx.AtendenteFx;
import io.github.pedroermarinho.aluguel_de_carro_fx.domain.repositories.AluguelRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView
public class MainController {

    private final FxControllerAndView<AtendenteController,AnchorPane> atedenteView;
    private final AluguelRepository aluguelRepository;

    public MainController(FxControllerAndView<AtendenteController, AnchorPane> atedenteView, AluguelRepository aluguelRepository) {
        this.atedenteView=atedenteView;
        this.aluguelRepository = aluguelRepository;
    }

    @FXML
    private TableView<AtendenteFx> aluguelTableView;

    @FXML
    private TableColumn<AtendenteFx, String> devoluçãoColumn;

    @FXML
    private TableColumn<AtendenteFx, Integer> diasColumn;

    @FXML
    private TableColumn<AtendenteFx, String> entregaColumn;

    @FXML
    private TableColumn<AtendenteFx, Double> valorColumn;

    @FXML
    void onAluguel(ActionEvent event) {

    }

    @FXML
    void onCarros(ActionEvent event) {

    }

    @FXML
    void onCliente(ActionEvent event) {

    }

    @FXML
    void onFuncionarios(ActionEvent event) {
        this.atedenteView.getController().show();
    }

    @FXML
    public void initialize() {
        devoluçãoColumn.setCellValueFactory(new PropertyValueFactory<>("devolucao"));
        diasColumn.setCellValueFactory(new PropertyValueFactory<>("dias"));
        entregaColumn.setCellValueFactory(new PropertyValueFactory<>("entrega"));
        valorColumn.setCellValueFactory(new PropertyValueFactory<>("valor"));
        updateTable();
    }

    private void updateTable() {
        final var list = aluguelRepository.findAll().stream().map(value -> new AluguelFx(
                value.getValor(),
                value.getDias(),
                value.getStatus(),
                value.getDevolucao().toString(),
                value.getEntrega().toString()
        )).collect(java.util.stream.Collectors.toList());
        if (!list.isEmpty()) {
            aluguelTableView.setItems(new ObservableListWrapper(list));
        }
    }





}
