package de.cofinpro.codingdojo.client;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.inject.Inject;

import de.cofinpro.codingdojo.server.api.Election;
import de.cofinpro.codingdojo.server.api.ElectionService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class PartyElectionController implements Initializable  {

    /* @Inject
    private ElectionService electionService;*/
    
    @FXML
    private ComboBox<String> electionList;
    
    @FXML 
    private GridPane selectElectionGrid;
    
    @FXML 
    private Text registerForElectionTarget;
    
    @FXML
    public void onRegisterForElection(){
    	if(!electionList.getValue().trim().equals("")){
    		
    	}else{
    		registerForElectionTarget.setText("Please select an election");
    	}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		/* List<String> elections = new ArrayList<String>();
		for(Election election : electionService.getElections()){
			elections.add(election.getName());
		}
		electionList.setItems(FXCollections.observableArrayList(new ArrayList(elections))); */
	}


}
