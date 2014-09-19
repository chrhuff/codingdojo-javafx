package de.cofinpro.codingdojo.server;

import de.cofinpro.codingdojo.server.api.Vote;
import de.cofinpro.codingdojo.server.api.Voter;
import de.cofinpro.codingdojo.server.api.VoterService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * Created by tahmed on 19.09.2014.
 */
@Path("voter")
public class VoterServiceImpl implements de.cofinpro.codingdojo.server.api.VoterService {

    /**
     * {@inheritDoc}
     */
    @POST
    @Path("register")
    @Consumes("application/json")
    @Produces("text/plain")
    @Override
    public Integer register(Voter voter) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @GET
    @Path("{voterId}")
    @Produces("application/json")
    @Override
    public Voter getVoter(@PathParam("voterId")Integer voterId) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @GET
    @Produces("application/json")
    @Override
    public Collection<Voter> getVoters() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @POST
    @Path("vote")
    @Produces("text/plain")
    @Consumes("application/json")
    @Override
    public Integer vote(Vote vote) {
        return null;
    }
}
