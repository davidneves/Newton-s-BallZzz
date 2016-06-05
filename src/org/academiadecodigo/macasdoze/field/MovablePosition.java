package org.academiadecodigo.macasdoze.field;

/**
 *
 *
 * Created by <vi.KINGS_> David Neves, Fábio Santos, Hélia Marcos and Mário Ponte on 24/05/2016.
 */
public interface MovablePosition extends Position {

    /**
     *
     * @param dx
     * @param dy
     */
    void move(int dx, int dy);
}
