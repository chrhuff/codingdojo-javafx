package de.cofinpro.codingdojo.server;

import de.cofinpro.codingdojo.server.api.Vote;
import de.cofinpro.codingdojo.server.api.Voter;
import de.cofinpro.codingdojo.server.api.VoterService;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by tahmed on 19.09.2014.
 */
public class VoterServiceImpl implements VoterService {

    @PersistenceContext(unitName = "codingdojo")
    private EntityManager entityManager;

    /**
     * {@inheritDoc}
     */

    @Override
    public Long register(Voter voter) {
        entityManager.persist(voter);
        return voter.getId();
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public Voter getVoter(@PathParam("voterId")Long voterId) {
        Voter voter = entityManager.find(Voter.class, voterId);
        return voter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<Voter> getVoters() {
        Voter voter = new Voter();
        voter.setId(24l);
        voter.setName("DummyVoter");
        return Arrays.asList(voter);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long vote(Vote vote) {
        return 23l;
    }
}
