package de.cofinpro.codingdojo.client;

import de.cofinpro.codingdojo.server.api.ApprovalService;
import de.cofinpro.codingdojo.server.api.ElectionService;
import de.cofinpro.codingdojo.server.api.PartyService;
import de.cofinpro.codingdojo.server.api.VoterService;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.enterprise.inject.Produces;

public class ProxyProducer {
    public static final String URI = "http://"+System.getProperty("evote.sever.ip", "192.168.59.103")+":8080/evote-server";
    @Produces
    public ElectionService produceElectionService() {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(URI);
        return target.proxy(ElectionService.class);
    }
    @Produces
    public PartyService producePartyService() {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(URI);
        return target.proxy(PartyService.class);
    }
    @Produces
    public VoterService produceVoterService() {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(URI);
        return target.proxy(VoterService.class);
    }

    @Produces
    public ApprovalService produceApprovalService() {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(URI);
        return target.proxy(ApprovalService.class);
    }
}
