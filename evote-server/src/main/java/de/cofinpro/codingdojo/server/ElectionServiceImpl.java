package de.cofinpro.codingdojo.server;

import de.cofinpro.codingdojo.server.api.Election;
import de.cofinpro.codingdojo.server.api.ElectionService;
import de.cofinpro.codingdojo.server.api.Party;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
        Election election = entityManager.find(Election.class, electionId);
        return entityManager.createNamedQuery("Vote.countVotes", Long.class)
                .setParameter("election", election).getSingleResult().intValue();    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getVotes(Long electionId, Long partyId) {
        Election election = entityManager.find(Election.class, electionId);
        Party party = entityManager.find(Party.class, partyId);
        return entityManager.createNamedQuery("Vote.countVotesForParty", Long.class)
                .setParameter("party", party)
                .setParameter("election", election).getSingleResult().intValue();
    }
}
