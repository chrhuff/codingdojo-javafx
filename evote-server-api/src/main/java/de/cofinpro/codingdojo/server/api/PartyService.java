package de.cofinpro.codingdojo.server.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.List;

/**
 * Created by tahmed on 19.09.2014.
 */
@Path("/party")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface PartyService {

    /**
     * Register a new party for the elections
     *
     * @param party
     */
    @PUT
    Long register(Party party);

    /**
     * @return get party
     */
    @GET
    @Path("/{partyId}")
    Party getParty(@PathParam("partyId") Long partyId);

    /**
     * @return get all parties
     */
    @GET
    List<Party> getParties();

    /**
     * Party apply for an election
     * @param party
     * @param election
     */
    @PUT
    @Path("/apply")
    void applyForElection(Party party, Election election);

}
