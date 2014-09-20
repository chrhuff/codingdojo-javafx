package de.cofinpro.codingdojo.server.api;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by tahmed on 19.09.2014.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Vote.countVotesForParty", query = "SELECT count(v) FROM Vote v where v.election = :election and v.party = :party"),
        @NamedQuery(name = "Vote.countVotes", query = "SELECT count(v) FROM Vote v where v.election = :election")
})
@XmlRootElement(name = "vote")
public class Vote {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @XmlElement(name = "voter")
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="VOTER_ID")
    private Voter voter;
    @XmlElement(name = "party")
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="PARTY_ID")
    private Party party;
    @XmlElement(name = "election")
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="ELECTION_ID")
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
