package de.cofinpro.codingdojo.client;

import de.cofinpro.codingdojo.client.javafx.ApprovalPartyListCell;
import de.cofinpro.codingdojo.client.javafx.ElectionListCell;
import de.cofinpro.codingdojo.client.javafx.PartyListCell;
import de.cofinpro.codingdojo.server.api.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

import javax.inject.Inject;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

public class BackendController implements Initializable {

    @FXML
    public ComboBox<Election> electionComboBox;
    @FXML
    public ComboBox<Approval> approvalComboBox;
    @FXML
    public Button approveBtn;
    @FXML
    public Button rejectBtn;
    @FXML
    public ComboBox<Election> electionForVoteComboBox;
    @FXML
    public ComboBox<Party> partyForVoteComboBox;
    @FXML
    public TextField voteField;
    @FXML
    public Button voteBtn;

    @Inject
    private ElectionService electionService;

    @Inject
    private ApprovalService approvalService;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Collection<Election> electionList = electionService.getElections();

        electionComboBox.setItems(FXCollections.observableArrayList(electionList));
        electionComboBox.setCellFactory(new Callback<ListView<Election>, ListCell<Election>>() {
            @Override
            public ListCell<Election> call(ListView<Election> p) {
                return new ElectionListCell();
            }
        });
        electionComboBox.setButtonCell(new ElectionListCell());
        electionComboBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Election selectedElection = electionComboBox.getSelectionModel().getSelectedItem();
                if (selectedElection != null) {
                    ObservableList<Approval> list = FXCollections.observableArrayList(
                            approvalService.getRequests(selectedElection.getId()));
                    approvalComboBox.setItems(list);
                }
            }
        });

        electionForVoteComboBox.setItems(FXCollections.observableArrayList(electionList));
        electionForVoteComboBox.setCellFactory(new Callback<ListView<Election>, ListCell<Election>>() {
            @Override
            public ListCell<Election> call(ListView<Election> p) {
                return new ElectionListCell();
            }
        });
        electionForVoteComboBox.setButtonCell(new ElectionListCell());
        electionForVoteComboBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Election selectedElection = electionForVoteComboBox.getSelectionModel().getSelectedItem();
                updateApprovalComboBox(selectedElection);
            }
        });

        approvalComboBox.setCellFactory(new Callback<ListView<Approval>, ListCell<Approval>>() {
            @Override
            public ListCell<Approval> call(ListView<Approval> p) {
                return new ApprovalPartyListCell();
            }
        });
        approvalComboBox.setButtonCell(new ApprovalPartyListCell());

        partyForVoteComboBox.setCellFactory(new Callback<ListView<Party>, ListCell<Party>>() {
            @Override
            public ListCell<Party> call(ListView<Party> p) {
                return new PartyListCell();
            }
        });
        partyForVoteComboBox.setButtonCell(new PartyListCell());


        approveBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Approval approval = approvalComboBox.getSelectionModel().getSelectedItem();
                approvalService.approve(approval.getId());
                Election selectedElection = electionForVoteComboBox.getSelectionModel().getSelectedItem();
                updateApprovalComboBox(selectedElection);
            }
        });

        rejectBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Approval approval = approvalComboBox.getSelectionModel().getSelectedItem();
                approvalService.reject(approval.getId());
                Election selectedElection = electionForVoteComboBox.getSelectionModel().getSelectedItem();
                updateApprovalComboBox(selectedElection);
            }
        });
        voteBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Election election = electionForVoteComboBox.getSelectionModel().getSelectedItem();
                Party party = partyForVoteComboBox.getSelectionModel().getSelectedItem();

                if(election == null || party == null || voteField.getText().isEmpty())
                {
                    voteField.setText("NAN");
                }
                electionService.vote(election.getId(), party.getId(), new Long(voteField.getText()));
            }
        });
    }

    private void updateApprovalComboBox(Election selectedElection) {
        if (selectedElection != null) {
            ObservableList<Party> list = FXCollections.observableArrayList(
                    electionService.getParties(selectedElection.getId()));
            partyForVoteComboBox.setItems(list);
        }
    }
}
