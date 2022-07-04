package io.github.pedroermarinho.aluguel_de_carro_fx.controller;

import com.sun.javafx.collections.ObservableListWrapper;
import io.github.pedroermarinho.aluguel_de_carro_fx.domain.entities.AtendenteEntity;
import io.github.pedroermarinho.aluguel_de_carro_fx.domain.entitiesFx.AtendenteFx;
import io.github.pedroermarinho.aluguel_de_carro_fx.domain.repositories.AtendenteRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView("CadastroFuncionario.fxml")
public class AtendenteController {

    private final AtendenteRepository atendenteRepository;


    private Stage stage;

    @FXML
    private TextField loginField;

    @FXML
    private TextField nomeField;

    @FXML
    private TextField senhaField;

    @FXML
    private AnchorPane telaPane;

    @FXML
    private TableColumn<AtendenteFx, String> lognColumn;

    @FXML
    private TableColumn<AtendenteFx, String> nomeColumn;

    @FXML
    private TableView<AtendenteFx> funcionariosTableView;


    public AtendenteController(AtendenteRepository atendenteRepository) {
        this.atendenteRepository = atendenteRepository;
    }

    @FXML
    void onCadastrar(ActionEvent event) {
        atendenteRepository.save(new AtendenteEntity(loginField.getText(), nomeField.getText(), senhaField.getText()));
        updateTable();
    }

    @FXML
    void onUpdateTable(ActionEvent event) {
        updateTable();
    }

    private void updateTable() {
        final var list = atendenteRepository.findAll().stream().map(value -> new AtendenteFx(value.getNome(), value.getLogin())).collect(java.util.stream.Collectors.toList());
        if (!list.isEmpty()) {
            funcionariosTableView.setItems(new ObservableListWrapper<>(list));
        }
    }

    @FXML
    public void initialize() {
        this.stage = new Stage();
        stage.setScene(new Scene(telaPane));
        nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        lognColumn.setCellValueFactory(new PropertyValueFactory<>("login"));
        updateTable();

    }

    public void show() {
        stage.show();
    }
}
