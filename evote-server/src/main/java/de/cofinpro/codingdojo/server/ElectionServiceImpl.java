package de.cofinpro.codingdojo.server;

import de.cofinpro.codingdojo.server.api.*;

import javax.ejb.EJB;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

/**
 * Created by Christian on 19.09.2014.
 */
@Singleton
@Lock(LockType.WRITE)
public class ElectionServiceImpl implements ElectionService {

    @PersistenceContext(unitName = "codingdojo")
    private EntityManager entityManager;

    @EJB
    private VoterDao voterDao;

    @EJB
    private PartyDao partyDao;

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

        Election election = getElection(electionId);
        if (election != null) {
            TypedQuery<Party> query = entityManager.createNamedQuery("Party.findByElectionApprovalStatus", Party.class);
            query.setParameter("election", election);
            query.setParameter("approvalStatus", ApprovalStatus.ZUGELASSEN);
            return query.getResultList();
        } else {
            return Collections.emptyList();
        }
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

    public Long vote(Party party, Election election, Long count) {
        long i = 0;
        for (; i < count; i++) {
            Voter fakeVoter = new Voter();
            fakeVoter.setName("Frank Bunny");
            //entityManager.persist(fakeVoter);
            //entityManager.flush();
            //entityManager.merge(party);
            //entityManager.merge(election);
            //Long id = voterDao.create(fakeVoter);
            //fakeVoter.setId(id);
            Vote fakeVote = new Vote();
            fakeVote.setVoter(fakeVoter);
            fakeVote.setParty(party);
            fakeVote.setElection(election);
            entityManager.merge(fakeVote);
        }
        return i;
    }

    @Override
    public Long vote(Long electionId, Long partyId, Long count) {
        Election election = getElection(electionId);
        Party party = partyDao.getParty(partyId);
        if(election == null)
        {
            throw new IllegalArgumentException("election GOT ILLEGAL VALUES");
        }
        if(party == null)
        {
            throw new IllegalArgumentException("party GOT ILLEGAL VALUES");
        }
        return vote(party, election, count);
    }
}
