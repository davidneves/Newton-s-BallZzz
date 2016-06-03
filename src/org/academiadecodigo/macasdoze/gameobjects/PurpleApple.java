package org.academiadecodigo.macasdoze.gameobjects;

import org.academiadecodigo.macasdoze.field.Position;

/**
 * Created by codecadet on 27/05/16.
 */
public class PurpleApple extends Apple {

    private int timeBoost;

    public PurpleApple(Position position, int fallSpeed, int points, int timeBoost) {
        super(position, fallSpeed, points);
        this.timeBoost = timeBoost;
    }

    /**
     * @see Apple#isFallen()
     *
     */
    public int getTimeBoost() {
        return timeBoost;
    }
}
