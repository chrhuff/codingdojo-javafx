package de.cofinpro.codingdojo.client;

import de.cofinpro.codingdojo.service.MinesweeperService;
//import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
//import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.enterprise.inject.Produces;

public class ProxyProducer {
    public static final String URI = "http://" + System.getProperty("minesweeper.server.ip", "localhost") + ":8080/mining-service/minesweeper";

    /*/@Produces
    public MinesweeperService produceMinesweeperService() {
        ResteasyWebTarget target = (ResteasyWebTarget) ResteasyClientBuilder.newClient()
                .target(URI);
        return target.proxy(MinesweeperService.class);
    }*/
}
