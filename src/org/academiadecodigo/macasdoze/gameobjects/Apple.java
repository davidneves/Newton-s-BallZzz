package org.academiadecodigo.macasdoze.gameobjects;

import org.academiadecodigo.macasdoze.field.Position;

/**
 * Defines what methods and properties an Apple will have.
 * <p>
 * Created by <vi.KINGS_> David Neves, Fábio Santos, Hélia Marcos and Mario Ponte on 23/05/16.
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

    /**
     * Makes the apple "fall" with a given speed.
     */
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

    /**
     * Increases the cycles that apples spent on the ground.
     */
    public void increaseFallenCycleCounter() {
        this.fallenCycleCounter++;
    }
}
