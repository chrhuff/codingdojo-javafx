package de.cofinpro.codingdojo.client;

import de.cofinpro.codingdojo.client.javafx.ElectionListCell;
import de.cofinpro.codingdojo.server.api.Election;
import de.cofinpro.codingdojo.server.api.ElectionService;
import de.cofinpro.codingdojo.server.api.Party;
import javafx.beans.*;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.effect.BlendMode;
import javafx.scene.text.Text;
import javafx.util.Callback;

import javax.inject.Inject;
import java.net.URL;
import java.util.*;

/**
 * Created by tahmed on 20.09.2014.
 */
public class ResultController implements Initializable {
    @FXML
    public ComboBox<Election> electionComboBox;
    @FXML
    public PieChart chart;

    ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

    @FXML
    public Text results;

    @Inject
    private ElectionService electionService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Collection<Election> electionList = electionService.getElections();

        electionComboBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Election selectedElection = electionComboBox.getSelectionModel().getSelectedItem();
                List<Party> parties = electionService.getParties(selectedElection.getId());
                updatePieChart(selectedElection, parties);
                updateTotal(selectedElection);
                updateLabel();
            }
        });
        electionComboBox.setItems(FXCollections.observableArrayList(electionList));
        electionComboBox.setCellFactory(new Callback<ListView<Election>, ListCell<Election>>() {
            @Override
            public ListCell<Election> call(ListView<Election> p) {
                return new ElectionListCell();
            }
        });
        electionComboBox.setButtonCell(new ElectionListCell());
        chart.setData(pieChartData);
        chart.setLabelsVisible(false);
        results.setVisible(false);
    }

    private void updateLabel() {
        chart.setLabelsVisible(false);
    }

    private void updateTotal(Election election) {
        results.setText(String.valueOf(electionService.getVotes(election.getId())));
        results.setVisible(true);
    }

    private void updatePieChart(Election election, List<Party> parties) {
        for (Party party : parties) {
            Integer votes = electionService.getVotes(election.getId(), party.getId());
            PieChart.Data data = new PieChart.Data(party.getName(), votes);
            pieChartData.add(data);
        }
    }
}
