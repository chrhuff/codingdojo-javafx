package de.cofinpro.codingdojo.client;

import de.cofinpro.codingdojo.server.api.Election;
import de.cofinpro.codingdojo.server.api.ElectionService;
import de.cofinpro.codingdojo.server.api.Party;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

import javax.inject.Inject;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

public class VoteController {
    @Inject
    private ElectionService electionService;
    @FXML
    private ListView party;

    @FXML
    public void vote() {
    }

    @FXML
    private ComboBox<Election> election;

    @FXML
    private Label label;
    @FXML
    private TextField nameField;
    @Inject
    private EvoteService evoteService;
    @FXML
    private GridPane pane1;
    @FXML
    private GridPane pane2;


    @Inject
    private FXMLLoader fxmlLoader;

    @FXML
    public void registerVoter() {
        pane1.setVisible(false);
        pane2.setVisible(true);
        Collection<Election> elections = electionService.getElections();
        election.setItems(FXCollections.observableList(new ArrayList(elections)));

        election.getSelectionModel().selectedItemProperty().addListener((selected, oldElection, newElection) -> {
            if (newElection != null) {
                ObservableList<Party> list = FXCollections.observableArrayList(
                        electionService.getParties(newElection.getId()));
                party.setItems(list);
            }
        });
    }
}
