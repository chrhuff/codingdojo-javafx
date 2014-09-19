package de.cofinpro.codingdojo.server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Christian on 19.09.2014.
 */
@Path("/test")
public class TestService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Integer getTest() {
        return 42;
    }
}
