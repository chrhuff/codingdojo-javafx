package de.cofinpro.codingdojo.server.api;

import javax.ejb.Local;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.List;

/**
 * Created by tahmed on 19.09.2014.
 */
@Path("/voter")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
@Local
public interface VoterService {

    /**
     * Register a voter for elections.
     *
     * @param voter
     */
    @POST
    @Path("/register")
    @Produces(MediaType.TEXT_PLAIN)
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
    @Produces(MediaType.TEXT_PLAIN)
    Long vote(Vote vote);
}
