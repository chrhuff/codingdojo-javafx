package de.cofinpro.codingdojo.client;

import javafx.application.Application;
import javafx.stage.Stage;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.io.IOException;

/**
 * Main runner. Boots up Weld and launches the JavaFX app.
 */
public class Runner extends Application {

    private SeContainer container;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() {
        SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        this.container = initializer.initialize();
    }

    @Override
    public void start(Stage stage) throws IOException {
        Instance<FxMain> instance = container.select(FxMain.class);
        FxMain fxMain = instance.get();
        fxMain.start(stage, getParameters());
    }

    @Override
    public void stop() {
        container.close();
    }
}