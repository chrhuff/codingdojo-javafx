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
public class ElectionServiceImpl implements ElectionService {

    final static Election ELECTION = new Election("Bundestagswahl 2017");
    final static Collection<Party> PARTIES = new ArrayList<>();
    final static Collection<Vote> VOTES = new ArrayList<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public Election getElection(Long electionId) {
        return ELECTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<Election> getElections() {
        return Arrays.asList(ELECTION);
    }

    @Override
    public Collection<Party> getParties(Long electionId) {
        return PARTIES;
    }

    @Override
    public Integer getVotes(Long electionId) {
        return VOTES.size();
    }

    @Override
    public Integer getVotes(Long electionId, Long partyId) {
        return VOTES.size();
    }
}
