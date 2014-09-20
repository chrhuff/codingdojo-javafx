package de.cofinpro.codingdojo.client;

import de.cofinpro.codingdojo.server.api.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import javax.inject.Inject;
import java.util.List;

public class BackendController {

    public ComboBox electionComboBox;
    public ComboBox approvalComboBox;
    public Button approveBtn;
    public Button rejectBtn;
    public ComboBox electionForVoteComboBox;
    public ComboBox partyForVoteComboBox;
    public TextField voteField;
    public Button voteBtn;
}
