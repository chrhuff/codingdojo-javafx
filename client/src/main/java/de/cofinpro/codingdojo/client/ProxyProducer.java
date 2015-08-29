package de.cofinpro.codingdojo.client;

import de.cofinpro.codingdojo.client.service.MinesweeperService;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.enterprise.inject.Produces;

public class ProxyProducer {
    public static final String URI = "http://" + System.getProperty("evote.sever.ip", "192.168.59.103") + ":8080/minig-service";

    @Produces
    public MinesweeperService produceMinesweeperService() {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(URI);
        return target.proxy(MinesweeperService.class);
    }
}
