package de.cofinpro.codingdojo.server.api;

import java.util.Collection;

/**
 * Created by tahmed on 19.09.2014.
 */
public interface VoterService {

    /**
     * Register a voter for elections.
     *
     * @param voter
     */
    Integer register(Voter voter);

    /**
     * @return get voter
     */
    Voter getVoter(Integer voterId);

    /**
     * @return get voters
     */
    Collection<Voter> getVoters();

    Integer vote(Vote vote);
}
