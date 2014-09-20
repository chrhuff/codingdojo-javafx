package de.cofinpro.codingdojo.server;

import de.cofinpro.codingdojo.server.api.*;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Christian on 19.09.2014.
 */
public class ElectionServiceImpl implements ElectionService {

    @PersistenceContext(unitName = "codingdojo")
    private EntityManager entityManager;

    @EJB
    private VoterDao voterDao;

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
                .setParameter("election", election).getSingleResult().intValue();
    }

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

    @Override
    public Long vote(Party party, Election election, int count) {
        long i = 0;
        for (; i < count; i++) {
            Voter fakeVoter = new Voter();
            fakeVoter.setName("Frank Bunny");
            entityManager.persist(fakeVoter);
            Vote fakeVote = new Vote();
            fakeVote.setVoter(fakeVoter);
            fakeVote.setParty(party);
            fakeVote.setElection(election);
            voterDao.createVote(fakeVote);
        }
        return i;
    }

    @Override
    public Long vote(long partyId, long electionId, int count) {
        Party party = entityManager.find(Party.class, partyId);
        Election election = entityManager.find(Election.class, electionId);
        return vote(party, election, count);
    }
}
