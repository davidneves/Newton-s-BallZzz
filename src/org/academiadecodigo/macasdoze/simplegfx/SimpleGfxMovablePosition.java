package org.academiadecodigo.macasdoze.simplegfx;

import org.academiadecodigo.macasdoze.field.MovablePosition;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.graphics.Shape;

/**
 * @see MovablePosition
 * @see SimpleGfxPosition
 * <p>
 * Created by vi.KINGS David Neves, Fabio Santos, Helia Marcos and Mario Ponte on 23/05/16.
 */
public abstract class SimpleGfxMovablePosition extends SimpleGfxPosition implements MovablePosition {

    public SimpleGfxMovablePosition(Shape shape) {
        super(shape);
    }


    @Override
    public void move(int dx, int dy) {
        if (getShape() instanceof Movable) {
            ((Movable) getShape()).translate(dx, dy);
        }
    }
}
