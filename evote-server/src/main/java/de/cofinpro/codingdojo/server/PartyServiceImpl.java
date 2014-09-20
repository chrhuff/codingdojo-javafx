package de.cofinpro.codingdojo.server;

import de.cofinpro.codingdojo.server.api.Election;
import de.cofinpro.codingdojo.server.api.Party;
import de.cofinpro.codingdojo.server.api.PartyService;

import java.util.List;

/**
 * Created by tahmed on 19.09.2014.
 */
public class PartyServiceImpl implements PartyService {
    @Override
    public Long register(Party party) {
        return null;
    }

    @Override
    public Party getParty(Long partyId) {
        return null;
    }

    @Override
    public List<Party> getParties() {
        return null;
    }

    @Override
    public Long applyForElection(Party party, Election election) {
        return null;
    }

}
