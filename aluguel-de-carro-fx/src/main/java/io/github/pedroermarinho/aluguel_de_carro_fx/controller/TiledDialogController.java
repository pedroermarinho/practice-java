package io.github.pedroermarinho.aluguel_de_carro_fx.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

/**
 * TiledDialogController.
 *
 * @author Rene Gielen
 * @noinspection WeakerAccess
 */
@Component
public class TiledDialogController {

    private Stage stage;
    @FXML
    private VBox dialog;
    @FXML
    public Button closeButton;


    @FXML
    public void initialize() {
        this.stage = new Stage();
        stage.setScene(new Scene(dialog));
    }

    public void show() {
        stage.show();
        closeButton.setOnAction(
                a -> stage.close()
        );
    }

}
