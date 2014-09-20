package de.cofinpro.codingdojo.server.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by tahmed on 19.09.2014.
 */
@Path("/voter")
@Consumes({"text/xml", "application/json"})
@Produces({"text/xml", "application/json"})
public interface VoterService {

    /**
     * Register a voter for elections.
     *
     * @param voter
     */
    @POST
    @Path("/register")
    Long register(Voter voter);

    /**
     * @return get voter
     */
    @GET
    @Path("/{voterId}")
    Voter getVoter(Long voterId);

    /**
     * @return get voters
     */
    @GET
    List<Voter> getVoters();

    @POST
    @Path("/vote")
    Long vote(Vote vote);
}
