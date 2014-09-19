package de.cofinpro.codingdojo.server.api;

import javax.ws.rs.*;
import java.util.Collection;

/**
 * Created by tahmed on 19.09.2014.
 */
public interface ElectionService {

    /**
     * @return election
     */
    Election getElection(Long electionId);

    /**
     * @return all elections
     */
    Collection<Election> getElections();

    /**
     * @return get all allowed parties for an election
     */
    Collection<Party> getParties(Election election);

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

}
