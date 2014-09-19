package de.cofinpro.codingdojo.client;

import de.cofinpro.codingdojo.server.api.Election;
import de.cofinpro.codingdojo.server.api.ElectionService;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import javax.inject.Inject;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

public class VoteController implements Initializable {
    @Inject
    private ElectionService electionService;

    @FXML
    public void vote() {

    }

    @FXML
    private ComboBox<Election> election;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Collection<Election> elections = electionService.getElections();
        election.setItems(FXCollections.observableList(new ArrayList(elections)));

        election.getSelectionModel().selectedItemProperty().addListener((selected, oldElection, newElection) -> {
            if (newElection != null) {
                System.out.println(newElection.toString());
            }
        });

    }
}
