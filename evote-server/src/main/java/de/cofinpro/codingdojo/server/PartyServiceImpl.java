package de.cofinpro.codingdojo.server;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.cofinpro.codingdojo.server.api.Approval;
import de.cofinpro.codingdojo.server.api.Election;
import de.cofinpro.codingdojo.server.api.Party;
import de.cofinpro.codingdojo.server.api.PartyService;
import de.cofinpro.codingdojo.server.api.STATUS;

public class PartyServiceImpl implements PartyService{

	@PersistenceContext(unitName = "codingdojo")
    private EntityManager entityManager;
	
	public Long register(Party party) {
		 entityManager.persist(party);
		 return party.getId();
	}

	public Party getParty(Long partyId) {
		
		return entityManager.find(Party.class, partyId);
	}

	public List<Party> getParties() {
		return entityManager.createNamedQuery("Party.findAll", Party.class).getResultList();
	}

	public void applyForElection(Party party, Election election) {
		
		Approval approval = new Approval(party.getId(), election.getId(), STATUS.BEANTRAGT.toString());
		
		entityManager.persist(approval);
		
	}
}
