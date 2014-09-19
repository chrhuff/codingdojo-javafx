package de.cofinpro.codingdojo.client;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import org.jboss.weld.environment.se.*;

/**
 * Main runner. Boots up Weld and launches the JavaFX app.
 */
public class Runner extends Application {
    private Weld weld;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() {
        weld = new Weld();
    }

    @Override
    public void start(Stage stage) throws IOException {
        weld.initialize().instance().select(FxMain.class).get().start(stage, getParameters());
    }

    @Override
    public void stop() {
        weld.shutdown();
    }
}