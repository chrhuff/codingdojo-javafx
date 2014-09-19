package de.cofinpro.codingdojo.server.api;

import java.util.Collection;

/**
 * Created by tahmed on 19.09.2014.
 */
public interface EVoteService {

    /**
     * Party apply for an election
     * @param party
     * @param election
     */
    void applyForElection(Party party, Election election);

    /**
     * Register a voter for elections.
     *
     * @param voter
     */
    void register(Voter voter);

    /**
     * Register a new party for the elections
     *
     * @param party
     */
    void register(Party party);

    /**
     * @return all elections
     */
    Collection<Election> getElections();

    /**
     * @return get all parties
     */
    Collection<Party> getParties();

    /**
     * @return get all allowed parties for an election
     */
    Collection<Party> getParties(Election election);

    /**
     * @return get voters
     */
    Collection<Voter> getVoters();

    /**
     * Returns the votes for an election
     * @param election election
     * @return get the votes for an election
     */
    Integer getVotes(Election election);

    /**
     * Returns the votes for an election
     * @param election election
     * @param party party
     * @return get the votes for an election
     */
    Integer getVotes(Election election, Party party);

    void vote(Vote vote);
}
