package de.cofinpro.codingdojo.server.api;

/**
 * Created by tahmed on 19.09.2014.
 */
public class Vote {
    private Voter voter;
    private Party party;
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
