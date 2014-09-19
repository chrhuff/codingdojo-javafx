package de.cofinpro.codingdojo.server;

import de.cofinpro.codingdojo.server.api.Election;
import de.cofinpro.codingdojo.server.api.ElectionService;
import de.cofinpro.codingdojo.server.api.Party;
import de.cofinpro.codingdojo.server.api.Vote;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Christian on 19.09.2014.
 */
public class ElectionServiceImpl implements ElectionService {

    @PersistenceContext(unitName = "codingdojo")
    private EntityManager entityManager;

    /**
     * {@inheritDoc}
     */
    @Override
    public Election getElection(Long electionId) {
        return entityManager.find(Election.class, electionId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Election> getElections() {
        return entityManager.createNamedQuery("Election.findAll", Election.class).getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Party> getParties(Long electionId) {
        return entityManager.createNamedQuery("Party.findAll", Party.class).getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getVotes(Long electionId) {
        return 42;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getVotes(Long electionId, Long partyId) {
       return 42;
    }
}
