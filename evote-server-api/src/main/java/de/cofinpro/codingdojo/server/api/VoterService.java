package de.cofinpro.codingdojo.server.api;

import javax.ws.rs.*;
import java.util.Collection;

/**
 * Created by tahmed on 19.09.2014.
 */
@Path("/voter")
public interface VoterService {

    /**
     * Register a voter for elections.
     *
     * @param voter
     */
    @POST
    @Path("register")
    @Consumes("application/json")
    @Produces("text/plain")
    Long register(Voter voter);

    /**
     * @return get voter
     */
    @GET
    @Path("{voterId}")
    @Produces("application/json")
    Voter getVoter(Long voterId);

    /**
     * @return get voters
     */
    @GET
    @Produces("application/json")
    Collection<Voter> getVoters();

    @POST
    @Path("vote")
    @Produces("text/plain")
    @Consumes("application/json")
    Long vote(Vote vote);
}
