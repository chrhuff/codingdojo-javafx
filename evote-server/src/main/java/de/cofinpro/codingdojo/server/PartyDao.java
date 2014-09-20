package de.cofinpro.codingdojo.server;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import de.cofinpro.codingdojo.server.api.Approval;
import de.cofinpro.codingdojo.server.api.Party;
import de.cofinpro.codingdojo.server.api.Vote;
import de.cofinpro.codingdojo.server.api.Voter;

public class PartyDao {

	 @PersistenceContext(unitName = "codingdojo")
	    private EntityManager entityManager;

	    public Long create(Party party) {
	        entityManager.persist(party);
	        entityManager.flush();
	        return party.getId();
	    }

	    public Voter update(Party party) {
	        return entityManager.merge(party);
	    }

	    public void delete(Party party) {
	        entityManager.remove(party);
	    }

	    public List<Party> getVoters() {
	        Query query = entityManager.createQuery("SELECT p from Party as p");
	        return query.getResultList();
	    }

	    public Party getVoter(Long partyId) {
	        return entityManager.find(Party.class, partyId);
	    }

	    public Long createVote(Party party) {
	        entityManager.persist(party);
	        entityManager.flush();;
	        return party.getId();
	    }
	    
	    public void persistApproval(Approval approval){
			entityManager.persist(approval);
			entityManager.flush();
	    }
}
