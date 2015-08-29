package de.cofinpro.codingdojo.client;

import javafx.fxml.FXMLLoader;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import java.nio.charset.StandardCharsets;

/**
 * This is a hack. We need to combine the JavaFX own injection (@FXML) with weld CDI.
 * This class creates a custom FXML-Loader which uses weld for injection / selection.
 */
public class FXMLLoaderProducer {
    @Inject
    Instance<Object> instance;

    @Produces
    public FXMLLoader createLoader() {
        return new FXMLLoader(null, null, null, param -> instance.select(param).get(), StandardCharsets.UTF_8);
    }
}
