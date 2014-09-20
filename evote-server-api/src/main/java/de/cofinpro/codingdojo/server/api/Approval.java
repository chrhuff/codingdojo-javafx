package de.cofinpro.codingdojo.server.api;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name = "Approval")
@NamedQueries({
	@NamedQuery(name = "Approval.findByStatus", query = "SELECT a FROM Approval a where a.status=:status and a.election=:election")
	})
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

    @Enumerated(value = EnumType.STRING)
	private ApprovalStatus status;
	
	public Approval(){}
	
	public Approval(Party party, Election election, ApprovalStatus status){
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

	public ApprovalStatus getStatus() {
		return status;
	}

	public void setStatus(ApprovalStatus status) {
		this.status = status;
	}
	
}
