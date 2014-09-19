package de.cofinpro.codingdojo.client;

import java.nio.charset.*;

import javafx.fxml.FXMLLoader;
import javafx.util.Callback;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

/**
 * Created by fweichand on 19.09.2014.
 */
public class FXMLLoaderProducer {
    @Inject
    Instance<Object> instance;

    @Produces
    public FXMLLoader createLoader() {
        return new FXMLLoader(null, null, null, param -> instance.select(param).get(), StandardCharsets.UTF_8);
    }
}
