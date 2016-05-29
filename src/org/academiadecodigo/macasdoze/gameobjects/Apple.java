package org.academiadecodigo.macasdoze.gameobjects;

import org.academiadecodigo.macasdoze.field.Position;

/**
 * Created by codecadet on 23/05/16.
 */
public abstract class Apple extends MovableGameObject {

    private int fallSpeed;
    private int points;
    private int fallenCycleCounter = 1;
    private boolean fallen;

    public Apple(Position position, int fallSpeed, int points) {
        super(position);
        this.fallSpeed = fallSpeed;
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public void fall() {
        super.move(0, fallSpeed);
    }

    public boolean isFallen() {
        return fallen;
    }

    public void setFallen(boolean fallen) {
        this.fallen = fallen;
    }

    public int getFallenCycleCounter() {
        return fallenCycleCounter;
    }

    public void increaseFallenCycleCounter() {
        this.fallenCycleCounter++;
    }
}
