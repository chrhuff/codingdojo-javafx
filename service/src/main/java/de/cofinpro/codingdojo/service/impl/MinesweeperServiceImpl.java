package de.cofinpro.codingdojo.service.impl;

import de.cofinpro.codingcojo.client.model.*;
import de.cofinpro.codingdojo.service.MinesweeperService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Dummy implementation for {@link MinesweeperService}.
 */
public class MinesweeperServiceImpl implements MinesweeperService {

    @Override
    public ActionResult submitAction(Integer sessionId, Action action) {
        System.out.println("Action submitted " + action);
        return new ActionResult(Collections.emptyList(), ClientStatus.CONTINUE);
    }

    @Override
    public Integer initGame(InitGameRequest request) {
        return 0;
    }

    private VisibleCell c(Integer x, Integer y, boolean flagged) {
        VisibleCell c = new VisibleCell();
        c.setX(x);
        c.setY(y);
        c.setFlagged(flagged);
        return c;
    }

    @Override
    public ActionResult getCurrentGameState(Integer sessionId) {
        List<VisibleCell> visibleCells = new ArrayList<>();
        visibleCells.add(c(0,0, false));
        visibleCells.add(c(0,1, false));
        visibleCells.add(c(1,0, true));
        visibleCells.add(c(1,1, false));
        return new ActionResult(visibleCells, ClientStatus.CONTINUE);
    }

    @Override
    public String getHighscore() {
        return "0";
    }
}
