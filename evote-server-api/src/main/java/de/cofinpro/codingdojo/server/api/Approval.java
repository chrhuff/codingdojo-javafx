package de.cofinpro.codingdojo.server.api;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import de.cofinpro.codingdojo.server.api.Election;
import de.cofinpro.codingdojo.server.api.Party;

@Entity
@XmlRootElement(name = "Approval")
@NamedQueries({@NamedQuery(name = "Approval.findAllowed", query = "SELECT a FROM Approval a where a.status='zugelassen' and a.election=:election"
)})
public class Approval {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="PARTY_ID")
	private Party party;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="ELECTION_ID")
	private Election election;
	
	private String status;
	
	public Approval(){}
	
	public Approval(Party party, Election election, String status){
		this.party= party;
		this.election = election;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	public Election getElection() {
		return election;
	}

	public void setElection(Election election) {
		this.election = election;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
