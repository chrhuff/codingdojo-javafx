package de.cofinpro.codingdojo.server.api;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name = "Approval")
@NamedQueries({@NamedQuery(name = "Election.findAll", query = "SELECT e FROM Election e"
)})
public class Approval {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	private Long partyId;

	private Long electionId;
	
	private String status;
	
	public Approval(Long partyId, Long electionId, String status){
		this.partyId = partyId;
		this.electionId = electionId;
		this.status = status;
	}
	
	public Long getPartyId() {
		return partyId;
	}

	public void setPartyId(Long partyId) {
		this.partyId = partyId;
	}

	public Long getElectionId() {
		return electionId;
	}

	public void setElectionId(Long electionId) {
		this.electionId = electionId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
