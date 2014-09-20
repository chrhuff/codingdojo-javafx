package de.cofinpro.codingdojo.server.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.List;

/**
 * Created by tahmed on 19.09.2014.
 */
@Path("/election")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public interface ElectionService {

    /**
     * @return election
     */
    @GET
    @Path("/{electionId}")
    Election getElection(@PathParam("electionId")Long electionId);

    /**
     * @return all elections
     */
    @GET
    List<Election> getElections();

    /**
     * @return get all allowed parties for an election
     */
    @GET
    @Path("/{electionId}/parties")
    List<Party> getParties(@PathParam("electionId")Long electionId);

    /**
     * Returns the votes for an election
     * @param electionId election Id
     * @return get the votes for an election
     */
    @GET
    @Path("/{electionId}/votes")
    @Produces(MediaType.TEXT_PLAIN)
    Integer getVotes(@PathParam("electionId")Long electionId);

    /**
     * Returns the votes for an election
     * @param electionId election
     * @param partyId party
     * @return get the votes for an election
     */
    @GET
    @Path("{electionId}/{partyId}/votes")
    @Produces(MediaType.TEXT_PLAIN)
    Integer getVotes(@PathParam("electionId")Long electionId, @PathParam("partyId")Long partyId);

}
