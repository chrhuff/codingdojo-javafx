package de.cofinpro.codingdojo.server;

import de.cofinpro.codingdojo.server.api.Election;
import de.cofinpro.codingdojo.server.api.Party;
import de.cofinpro.codingdojo.server.api.Vote;
import de.cofinpro.codingdojo.server.api.Voter;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static org.junit.Assert.assertTrue;

public class ElectionServiceImplTest {

    @Test
    public void test() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("codingdojoTest");
        EntityManager em = emf.createEntityManager();
        EntityTransaction trx = null;
        try {
            //Get a new transaction
            trx = em.getTransaction();

            //Start the transaction
            trx.begin();
            Voter voter = new Voter();
            voter.setName("Tester!");
            em.persist(voter);
            Voter voter2 = new Voter();
            voter2.setName("Tester2!");
            em.persist(voter2);
            trx.commit();

            trx.begin();
            Party csu = new Party();
            csu.setName("CSU");
            em.persist(csu);

            Party pbc = new Party();
            pbc.setName("PBC");
            em.persist(pbc);
            trx.commit();

            trx.begin();
            Election election = new Election();
            election.setName("Bayerische Unabhängigkeit");
            em.persist(election);
            trx.commit();

            trx.begin();
            Vote vote = new Vote();
            vote.setElection(election);
            vote.setParty(csu);
            vote.setVoter(voter);
            em.persist(vote);

            Vote vote2 = new Vote();
            vote2.setElection(election);
            vote2.setParty(csu);
            vote2.setVoter(voter2);
            em.persist(vote2);
            trx.commit();

            assertTrue(em.createNamedQuery("Vote.countVotes", Long.class).setParameter("election", election).setParameter("party", csu).getSingleResult().longValue() == 2l);
            assertTrue(em.createNamedQuery("Vote.countVotes", Long.class).setParameter("election", election).setParameter("party", pbc).getSingleResult().longValue() == 0l);

        } catch (RuntimeException e) {
            if (trx != null && trx.isActive()) {
                trx.rollback();
            }
            throw e;
        } finally {
            //Close the manager
            em.close();
            emf.close();
        }
    }

}
