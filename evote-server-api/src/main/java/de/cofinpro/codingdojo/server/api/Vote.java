package de.cofinpro.codingdojo.server.api;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by tahmed on 19.09.2014.
 */
@Entity
@XmlRootElement(name = "vote")
public class Vote {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @XmlElement(name = "voter")
    private Voter voter;
    @XmlElement(name = "party")
    private Party party;
    @XmlElement(name = "election")
    private Election election;

    public Vote(){
    }

    public Vote(Voter voter, Party party, Election election)
    {
        this.voter = voter;
        this.party = party;
        this.election = election;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Voter getVoter() {
        return voter;
    }

    public void setVoter(Voter voter) {
        this.voter = voter;
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

}
