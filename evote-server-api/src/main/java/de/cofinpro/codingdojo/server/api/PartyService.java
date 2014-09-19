package de.cofinpro.codingdojo.server.api;

import javax.ws.rs.*;
import java.util.Collection;

/**
 * Created by tahmed on 19.09.2014.
 */
@Path("/party")
public interface PartyService {

    /**
     * Register a new party for the elections
     *
     * @param party
     */
    @POST
    @Path("register")
    @Consumes("application/json")
    @Produces("text/plain")
    Long register(Party party);

    /**
     * @return get party
     */
    @GET
    @Path("{partyId}")
    @Produces("application/json")
    Party getParty(@PathParam("partyId")Long partyId);

    /**
     * @return get all parties
     */
    @GET
    @Produces("application/json")
    Collection<Party> getParties();

    /**
     * Party apply for an election
     * @param partyId
     * @param electionId
     */
    @POST
    @Path("/vote")
    Long applyForElection(Long partyId, Long electionId);

}
