package de.cofinpro.codingcojo.client.model;

/**
 * Created by chuff on 28.08.2015.
 */
public class VisibleCell {

    private int number = -1;
    private Boolean mine;
    private Integer x;
    private Integer y;
    private boolean flagged;

    public int getNumber() {
        return number;
    }

    public Boolean isMine() {
        return mine;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setMine(Boolean mine) {
        this.mine = mine;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }
}
