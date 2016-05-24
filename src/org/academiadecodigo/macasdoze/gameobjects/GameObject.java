package org.academiadecodigo.macasdoze.gameobjects;

import org.academiadecodigo.macasdoze.field.Position;

/**
 * Created by codecadet on 23/05/16.
 */
public abstract class GameObject {

    private Position position;


    public GameObject(Position position) {
        this.position = position;
    }

    
    public Position getPosition() {
        return position;
    }

}
