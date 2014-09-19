package de.cofinpro.codingdojo.server.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * Created by tahmed on 19.09.2014.
 */
@Path("/voter")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface VoterService {

    /**
     * Register a voter for elections.
     *
     * @param voter
     */
    @POST
    @Path("register")
    Long register(Voter voter);

    /**
     * @return get voter
     */
    @GET
    @Path("{voterId}")
    Voter getVoter(Long voterId);

    /**
     * @return get voters
     */
    @GET
    Collection<Voter> getVoters();

    @POST
    @Path("vote")
    Long vote(Vote vote);
}
