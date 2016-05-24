package org.academiadecodigo.macasdoze.gameobjects;

import org.academiadecodigo.macasdoze.field.Position;

/**
 * Created by codecadet on 23/05/16.
 */
public class Newton extends  MovableGameObject{

    public Newton(Position position) {
        super(position);
    }


    public void moveLeft(int dx) {
        super.move( -dx, 0);
    }

    public void moveRight(int dx) {
        super.move(dx, 0);
    }

}
