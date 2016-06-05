package org.academiadecodigo.macasdoze.gameobjects;

import org.academiadecodigo.macasdoze.field.Position;

/**
 * @see Apple
 *
 * Created by <vi.KINGS_> David Neves, Fábio Santos, Hélia Marcos and Mario Ponte on 27/05/16.
 */
public class PurpleApple extends Apple {

    private int timeBoost;

    public PurpleApple(Position position, int fallSpeed, int points, int timeBoost) {
        super(position, fallSpeed, points);
        this.timeBoost = timeBoost;
    }

    public int getTimeBoost() {
        return timeBoost;
    }
}
