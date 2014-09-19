package de.cofinpro.codingdojo.client;

import de.cofinpro.codingdojo.server.api.ElectionService;
import de.cofinpro.codingdojo.server.api.PartyService;
import de.cofinpro.codingdojo.server.api.VoterService;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ws.rs.Produces;

/**
 * Created by fweichand on 19.09.2014.
 */
public class ProxyProducer {

    public static final String ELECTION_URI = "http://example.com/base/uri";
    public static final String PARTY_URI = "http://example.com/base/uri";
    public static final String VOTER_URI = "http://example.com/base/uri";

    //@Produces
    public ElectionService produceElectionService() {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(ELECTION_URI);
        return target.proxy(ElectionService.class);
    }
    //@Produces
    public PartyService producePartyService() {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(PARTY_URI);
        return target.proxy(PartyService.class);
    }
    //@Produces
    public VoterService produceVoterService() {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(VOTER_URI);
        return target.proxy(VoterService.class);
    }

}
