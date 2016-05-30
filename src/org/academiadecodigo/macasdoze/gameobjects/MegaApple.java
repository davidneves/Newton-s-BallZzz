package org.academiadecodigo.macasdoze.gameobjects;

import org.academiadecodigo.macasdoze.field.Position;

/**
 * Created by codecadet on 27/05/16.
 */
public class MegaApple extends Apple {

    private int timeBoost;

    public MegaApple(Position position, int fallSpeed, int points, int timeBoost) {
        super(position, fallSpeed, points);
        this.timeBoost = timeBoost;
    }

    public int getTimeBoost() {
        return timeBoost;
    }
}
