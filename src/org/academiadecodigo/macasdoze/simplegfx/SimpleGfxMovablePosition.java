package org.academiadecodigo.macasdoze.simplegfx;

import org.academiadecodigo.macasdoze.field.MovablePosition;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.graphics.Shape;

/**
 * Created by <vi.KINGS_> David Neves, Fábio Santos, Hélia Marcos and Mário Ponte on 24/05/2016.
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
