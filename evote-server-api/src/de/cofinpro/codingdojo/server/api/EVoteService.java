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


    Collection<Election> getElections();

    Collection<Party> getParties();

    Collection<Voter> getVoters();

    void vote(Vote vote);
}
