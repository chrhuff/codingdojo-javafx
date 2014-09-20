package de.cofinpro.codingdojo.client;

import de.cofinpro.codingdojo.server.api.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javax.inject.Inject;
import java.util.List;

public class VoteController {

    @FXML
    private ListView party;
    @Inject
    private VoterService voterService;
    @Inject
    private ElectionService electionService;

    @FXML
    public void vote() {
    }

    @FXML
    private ComboBox<Election> election;

    @FXML
    private Label label;
    @FXML
    private TextField nameField;

    @FXML
    private GridPane pane1;
    @FXML
    private GridPane pane2;
    @Inject
    private FXMLLoader fxmlLoader;

    private Election selectedElection;

    @FXML
    public void registerVoter() {

        Voter voter = new Voter();
        voter.setName(nameField.getText());
        Long myId = voterService.register(voter);

        List<Election> elections = electionService.getElections();
        election.setItems(FXCollections.observableList(elections));

        election.getSelectionModel().selectedItemProperty().addListener((selected, oldElection, newElection) -> {
            if (newElection != null) {
                ObservableList<Party> list = FXCollections.observableArrayList(
                        electionService.getParties(newElection.getId()));
                party.setItems(list);
                selectedElection = newElection;
            }
        });
        pane1.setVisible(false);
        pane2.setVisible(true);
    }

    @FXML
    public void castVote() {
    }
}
