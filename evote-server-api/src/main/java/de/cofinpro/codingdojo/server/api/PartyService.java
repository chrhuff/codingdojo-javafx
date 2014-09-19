package de.cofinpro.codingdojo.server.api;

import java.util.Collection;

/**
 * Created by tahmed on 19.09.2014.
 */
public interface PartyService {

    /**
     * Register a new party for the elections
     *
     * @param party
     */
    Integer register(Party party);

    /**
     * @return get party
     */
    Party getParty(Integer partyId);

    /**
     * @return get all parties
     */
    Collection<Party> getParties();

    /**
     * Party apply for an election
     * @param party
     * @param election
     */
    Integer applyForElection(Party party, Election election);

}
