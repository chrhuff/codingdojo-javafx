package de.cofinpro.codingdojo.service;

import de.cofinpro.codingcojo.client.model.Action;
import de.cofinpro.codingcojo.client.model.ActionResult;
import de.cofinpro.codingcojo.client.model.InitGameRequest;

/**
 * Created by chuff on 29.08.2015.
 */
public interface MinesweeperService {

    ActionResult submitAction(Integer sessionId, Action action);

    Integer initGame(InitGameRequest request);

    ActionResult getCurrentGameState(Integer sessionId);

    String getHighscore();
}
