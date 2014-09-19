package de.cofinpro.codingdojo.server;

import de.cofinpro.codingdojo.server.api.Election;
import de.cofinpro.codingdojo.server.api.ElectionService;
import de.cofinpro.codingdojo.server.api.Party;
import de.cofinpro.codingdojo.server.api.Vote;

import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Christian on 19.09.2014.
 */
@Path("/election")
public class ElectionServiceImpl implements ElectionService {

    final static Election ELECTION = new Election();
    final static Collection<Party> PARTIES = new ArrayList<>();
    final static Collection<Vote> VOTES = new ArrayList<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public Election getElection(Integer electionId) {
        return ELECTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<Election> getElections() {
        return Arrays.asList(ELECTION);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<Party> getParties(Election election) {
        return PARTIES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getVotes(Election election) {
        return VOTES.size();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getVotes(Election election, Party party) {
        return VOTES.size();
    }
}
