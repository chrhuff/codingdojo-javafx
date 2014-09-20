package de.cofinpro.codingdojo.client;

import de.cofinpro.codingdojo.client.javafx.ElectionListCell;
import de.cofinpro.codingdojo.server.api.Election;
import de.cofinpro.codingdojo.server.api.ElectionService;
import de.cofinpro.codingdojo.server.api.Party;
import de.cofinpro.codingdojo.server.api.PartyService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.util.Callback;

import javax.inject.Inject;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Main controller. Delegate JavaFX callbacks to separate services.
 * We can use CDI here :-).
 */
public class PartyController implements Initializable {

    @FXML
    private Text registerPartytarget;

    @FXML
    private TextField partyName;

    @FXML
    private GridPane registerPartyGrid;

    @FXML
    private FlowPane root;

    @Inject
    private ElectionService electionService;

    @Inject
    private PartyService partyService;

    @FXML
    private ComboBox<Election> electionList;

    @FXML
    private GridPane selectElectionGrid;

    @FXML
    private Text registerForElectionTarget;

    private Party registeredParty;

    @FXML
    public void onRegisterPartyClick() throws IOException {
        if (!partyName.getText().trim().equals("")) {
            Party party = new Party(partyName.getText().trim());
            Long partyId = partyService.register(party);
            party.setId(partyId);
            registerPartytarget.setText("Party '" + partyName.getText() + "' registered, party ID is " + partyId);
            this.registeredParty = party;
        }

        registerPartyGrid.setVisible(false);
        selectElectionGrid.setVisible(true);
        List<Election> elections = electionService.getElections();
        electionList.setItems(FXCollections.observableArrayList(elections));
    }

    @FXML
    public void onRegisterForElection() {
        Election election = electionList.getSelectionModel().getSelectedItem();
        if (election != null) {

            partyService.applyForElection(registeredParty, election);
        } else {
            registerForElectionTarget.setText("Please select an election");
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        electionList.setCellFactory(new Callback<ListView<Election>, ListCell<Election>>() {
            @Override
            public ListCell<Election> call(ListView<Election> p) {
                return new ElectionListCell();
            }
        });
        electionList.setButtonCell(new ElectionListCell());

        selectElectionGrid.setVisible(false);
        registerPartyGrid.setVisible(true);
    }
}
