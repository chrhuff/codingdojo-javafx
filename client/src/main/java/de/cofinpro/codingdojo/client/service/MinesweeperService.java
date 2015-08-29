package de.cofinpro.codingdojo.client.service;

import de.cofinpro.codingcojo.client.model.Action;
import de.cofinpro.codingcojo.client.model.ActionResult;

import javax.ws.rs.*;

/**
 * Created by chuff on 29.08.2015.
 */
@Consumes("application/json")
public interface MinesweeperService {

    @PUT
    @Path("/{sessid}")
    ActionResult submitAction(@PathParam("sessid") Integer sessionId, Action action);

    @POST
    Integer initGame(InitGameRequest request);

    @GET
    @Path("/{sessid}")
    ActionResult getCurrentGameState(@PathParam("sessid") Integer sessionId);

    @GET
    @Path("/highscore")
    String getHighscore();

}
