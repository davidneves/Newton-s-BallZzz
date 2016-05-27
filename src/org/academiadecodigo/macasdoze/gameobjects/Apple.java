package org.academiadecodigo.macasdoze.gameobjects;

import org.academiadecodigo.macasdoze.field.Position;

/**
 * Created by codecadet on 23/05/16.
 */
public abstract class Apple extends MovableGameObject{

    public static final int SIZE = 20;
    private int fallSpeed;
    private int points;
    private boolean collected;

    public Apple(Position position, int fallSpeed, int points) {
        super(position);
        this.fallSpeed = fallSpeed;
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void fall() {
        super.move(0, fallSpeed);
    }

}
