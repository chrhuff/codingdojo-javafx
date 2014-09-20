package de.cofinpro.codingdojo.server;

import de.cofinpro.codingdojo.server.api.Vote;
import de.cofinpro.codingdojo.server.api.Voter;
import de.cofinpro.codingdojo.server.api.VoterService;

import javax.ejb.*;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.PathParam;
import java.util.List;

/**
 * Created by tahmed on 19.09.2014.
 */
@Singleton
@Lock(LockType.WRITE)
public class VoterServiceImpl implements VoterService {

    @EJB
    private VoterDao voterDao;

    /**
     * {@inheritDoc}
     */

    @Override
    public Long register(Voter voter) {
        return voterDao.create(voter);
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public Voter getVoter(@PathParam("voterId")Long voterId) {
        return voterDao.getVoter(voterId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Voter> getVoters() {
        return voterDao.getVoters();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long vote(Vote vote) {
        return voterDao.createVote(vote);
    }
}
