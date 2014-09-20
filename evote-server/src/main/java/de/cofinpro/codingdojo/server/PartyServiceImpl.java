package de.cofinpro.codingdojo.server;

import de.cofinpro.codingdojo.server.api.*;

import javax.ejb.EJB;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import java.util.List;

import de.cofinpro.codingdojo.server.api.*;
import de.cofinpro.codingdojo.server.api.ApprovalStatus;

@Singleton
@Lock(LockType.WRITE)
public class PartyServiceImpl implements PartyService {

	@EJB 
	private PartyDao partyDao;
	
	@Override
	public Long register(Party party) {
		return partyDao.create(party);
	}

    @Override
    public Party getParty(Long partyId) {
        return partyDao.getParty(partyId);
    }
	@Override
	public List getParties() {
		return partyDao.getParties();
	}

    @Override
    public Long applyForElection(Long electionId, Long partyId) {
        Approval approval = partyDao.requestApproval(electionId, partyId);
        partyDao.persistApproval(approval);
        return approval.getId();
    }
}
