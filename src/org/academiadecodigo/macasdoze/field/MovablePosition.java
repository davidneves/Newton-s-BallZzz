package org.academiadecodigo.macasdoze.field;

/**
 * To be implemented by the MovablePosition of the defined library.
 * <p>
 * Moves the object's position.
 * <p>
 * Created by vi.KINGS David Neves, Fabio Santos, Helia Marcos and Mario Ponte on 23/05/16.
 */
public interface MovablePosition extends Position {

    /**
     * Translates the shape of the defined library.
     *
     * @param dx
     * @param dy
     */
    void move(int dx, int dy);
}
