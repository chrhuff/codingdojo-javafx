package de.cofinpro.codingdojo.server;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

import de.cofinpro.codingdojo.server.api.*;
import de.cofinpro.codingdojo.server.api.ApprovalStatus;

@Singleton
@Lock(LockType.WRITE)
public class PartyServiceImpl implements PartyService{

	@EJB 
	PartyDao partyDao;
	
	@Override
	public Long register(Party party) {
		return partyDao.create(party);
	}

	@Override
	public Party getParty(Long partyId) {
		return partyDao.getVoter(partyId);
	}

	@Override
	public List getParties() {
		return partyDao.getVoters();
	}

	@Override
	public Long applyForElection(Party party, Election election) {
    	Approval approval = new Approval(party, election, ApprovalStatus.BEANTRAGT);
    	partyDao.persistApproval(approval);
    	return approval.getId();
	}
}
