package org.academiadecodigo.macasdoze.field;

/**
 * To be implemented by the MovablePosition of the defined library.
 *
 * Moves the object's position.
 *
 * Created by <vi.KINGS_> David Neves, Fábio Santos, Hélia Marcos and Mario Ponte on 24/05/2016.
 */
public interface MovablePosition extends Position {

    /**
     *
     * Translates the shape of the defined library.
     *
     * @param dx
     * @param dy
     */
    void move(int dx, int dy);
}
