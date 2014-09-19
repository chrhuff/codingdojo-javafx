package de.cofinpro.codingdojo.server.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Collection;

/**
 * Created by tahmed on 19.09.2014.
 */
@Path("/election")
public interface ElectionService {

    /**
     * @return election
     */
    Election getElection(Integer electionId);

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
    @GET
    Integer getVotes(Election election);

    /**
     * Returns the votes for an election
     * @param election election
     * @param party party
     * @return get the votes for an election
     */
    @Produces("text/plain")
    Integer getVotes(Election election, Party party);

}
