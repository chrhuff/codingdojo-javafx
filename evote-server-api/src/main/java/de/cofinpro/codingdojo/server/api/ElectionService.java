package de.cofinpro.codingdojo.server.api;

import javax.ws.rs.*;
import java.util.Collection;

/**
 * Created by tahmed on 19.09.2014.
 */
@Path("/election")
public interface ElectionService {

    /**
     * @return election
     */
    @GET
    @Path("{electionId}")
    @Produces("application/json")
    Election getElection(@PathParam("electionId")Long electionId);

    /**
     * @return all elections
     */
    @GET
    @Produces("application/json")
    Collection<Election> getElections();

    /**
     * @return get all allowed parties for an election
     */
    @GET
    @Path("{electionId}/parties")
    @Produces("application/json")
    Collection<Party> getParties(@PathParam("electionId")Long electionId);

    /**
     * Returns the votes for an election
     * @param electionId election Id
     * @return get the votes for an election
     */
    @GET
    @Path("{electionId}/votes")
    @Produces("application/json")
    Integer getVotes(@PathParam("electionId")Long electionId);

    /**
     * Returns the votes for an election
     * @param electionId election
     * @param partyId party
     * @return get the votes for an election
     */
    @GET
    @Path("{electionId}/{partyId}/votes")
    @Produces("application/json")
    Integer getVotes(@PathParam("electionId")Long electionId, @PathParam("partyId")Long partyId);

}
