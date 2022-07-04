package io.github.pedroermarinho.aluguel_de_carro_fx.application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import io.github.pedroermarinho.aluguel_de_carro_fx.AluguelDeCarroFxApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class SpringbootJavaFxApplication extends Application {

    private ConfigurableApplicationContext context;

    @Override
    public void init() throws Exception {
        ApplicationContextInitializer<GenericApplicationContext> initializer =
                context -> {
                    context.registerBean(Application.class, () -> SpringbootJavaFxApplication.this);
                    context.registerBean(Parameters.class, this::getParameters); // for demonstration, not really needed
                };
        this.context = new SpringApplicationBuilder()
                .sources(AluguelDeCarroFxApplication.class)
                .initializers(initializer)
                .run(getParameters().getRaw().toArray(new String[0]));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        context.publishEvent(new StageReadyEvent(primaryStage));
    }

    @Override
    public void stop() throws Exception {
        this.context.close();
        Platform.exit();
    }
}
