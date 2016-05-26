package org.academiadecodigo.macasdoze.gameobjects;

import org.academiadecodigo.macasdoze.field.Position;

/**
 * Created by codecadet on 23/05/16.
 */
public abstract class Apple extends MovableGameObject{

    private int fallSpeed;
    private boolean collected;

    public Apple(Position position, int fallSpeed) {
        super(position);
        this.fallSpeed = fallSpeed;
    }

    public void fall() {
        super.move(0, fallSpeed);
    }

}
