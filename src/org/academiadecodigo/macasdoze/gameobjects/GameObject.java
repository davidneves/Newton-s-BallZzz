package org.academiadecodigo.macasdoze.gameobjects;

import org.academiadecodigo.macasdoze.field.Position;

/**
 * Defines what every object will be
 * <p>
 * <p>
 * Created by <vi.KINGS_> David Neves, Fábio Santos, Hélia Marcos and Mário Ponte on 23/05/16.
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
