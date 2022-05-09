package io.github.pedroermarinho.aluguel_de_carro_fx.application;

import javafx.stage.Stage;
import org.springframework.context.ApplicationEvent;

/**
 * @author <a href="mailto:rene.gielen@gmail.com">Rene Gielen</a>
 * @noinspection WeakerAccess
 */
public class StageReadyEvent extends ApplicationEvent {

    public final Stage stage;

    public StageReadyEvent(Stage stage) {
        super(stage);
        this.stage = stage;
    }
}
