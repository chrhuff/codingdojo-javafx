package de.cofinpro.codingdojo.client.mock;

import de.cofinpro.codingdojo.server.api.Election;
import de.cofinpro.codingdojo.server.api.ElectionService;
import de.cofinpro.codingdojo.server.api.Party;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by fweichand on 19.09.2014.
 */
public class ElectionServiceMock implements ElectionService {
    @Override
    public Election getElection(Integer electionId) {
        return null;
    }

    @Override
    public Collection<Election> getElections() {
        Election o = new Election(null, "Unabhängiges Bayern");
        return Collections.singletonList(o);
    }

    @Override
    public Collection<Party> getParties(Election election) {
        Party o = new Party(null, "Einheitspartei");
        return Collections.singletonList(o);
    }

    @Override
    public Integer getVotes(Election election) {
        return null;
    }

    @Override
    public Integer getVotes(Election election, Party party) {
        return null;
    }
}
