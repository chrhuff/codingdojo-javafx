package de.cofinpro.codingdojo.client;

import de.cofinpro.codingdojo.server.api.Election;
import de.cofinpro.codingdojo.server.api.ElectionService;
import de.cofinpro.codingdojo.server.api.Party;
import de.cofinpro.codingdojo.server.api.PartyService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import javax.inject.Inject;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
    private ComboBox<String> electionList;
    
    @FXML 
    private GridPane selectElectionGrid;
    
    @FXML 
    private Text registerForElectionTarget;
    
    private Long partyId;
    
    @FXML
    public void onRegisterPartyClick() throws IOException {
    	if(!partyName.getText().trim().equals("")){

            Party party = new Party(partyName.getText().trim());

            partyId = partyService.register(party);

            registerPartytarget.setText("Party '" + partyName.getText() + "' registered, party ID is " + partyId);

	    	registerPartyGrid.setVisible(false);
	    	selectElectionGrid.setVisible(true);
	    	
	    	List<String> elections = new ArrayList<String>();
			for(Election election : electionService.getElections()){
				elections.add(election.getName());
			}
			electionList.setItems(FXCollections.observableArrayList(new ArrayList(elections)));
		}
    }
    
    @FXML
    public void onRegisterForElection(){
    	if(!electionList.getValue().trim().equals("")){
    		Election election = getElection(electionList.getValue().trim());
    		Party party = partyService.getParty(partyId);
    		partyService.applyForElection(party, election);
    	}else{
    		registerForElectionTarget.setText("Please select an election");
    	}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	
    	selectElectionGrid.setVisible(false);
    	registerPartyGrid.setVisible(true);
	}
	
	private Election getElection(String name){
		for(Election election : electionService.getElections()){
			if(election.getName().equals(name))
				return election;
		}
		return null;
	}

}
