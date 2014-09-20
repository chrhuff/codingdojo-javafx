package de.cofinpro.codingdojo.server;

import de.cofinpro.codingdojo.server.api.Vote;
import de.cofinpro.codingdojo.server.api.Voter;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.PathParam;
import java.util.List;

/**
 * Created by Christian on 20.09.2014.
 */
@Stateless
@TransactionAttribute(value = TransactionAttributeType.REQUIRES_NEW)
public class VoterDao {

    @PersistenceContext(unitName = "codingdojo")
    private EntityManager entityManager;

    public Long create(Voter voter) {
        entityManager.persist(voter);
        entityManager.flush();
        return voter.getId();
    }

    public Voter update(Voter voter) {
        return entityManager.merge(voter);
    }

    public void delete(Voter voter) {
        entityManager.remove(voter);
    }

    public List<Voter> getVoters() {
        Query query = entityManager.createQuery("SELECT v from Voter as v");
        return query.getResultList();
    }

    public Voter getVoter(Long voterId) {
        return entityManager.find(Voter.class, voterId);
    }

    public Long createVote(Vote vote) {
        entityManager.persist(vote);
        entityManager.flush();
        return vote.getId();
    }
}
