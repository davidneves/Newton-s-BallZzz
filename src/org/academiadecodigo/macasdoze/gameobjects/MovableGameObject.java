package org.academiadecodigo.macasdoze.gameobjects;

import org.academiadecodigo.macasdoze.field.MovablePosition;
import org.academiadecodigo.macasdoze.field.Position;

/**
 *
 * @see GameObject
 *
 * Created by vi.KINGS David Neves, Fabio Santos, Helia Marcos and Mario Ponte on 23/05/16.
 */
public abstract class MovableGameObject extends GameObject {

    public MovableGameObject(Position position) {
        super(position);
    }


    public void move(int dx, int dy) {
        ((MovablePosition) getPosition()).move(dx, dy);
    }

}
