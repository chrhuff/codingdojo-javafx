package de.cofinpro.codingdojo.server.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by tahmed on 19.09.2014.
 */
@XmlRootElement(name = "vote")
public class Vote {
    @XmlElement(name = "voter")
    private Voter voter;
    @XmlElement(name = "party")
    private Party party;
    @XmlElement(name = "election")
    private Election election;

    private Vote(){
    }

    public Vote(Voter voter, Party party, Election election)
    {
        this.voter = voter;
        this.party = party;
        this.election = election;
    }

    public Voter getVoter() {
        return voter;
    }

    public Party getParty() {
        return party;
    }

    public Election getElection() {
        return election;
    }
}
