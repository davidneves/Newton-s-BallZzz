package org.academiadecodigo.macasdoze.simplegfx;

import org.academiadecodigo.macasdoze.field.Position;
import org.academiadecodigo.simplegraphics.graphics.Shape;

/**
 * Created by <vi.KING_> David Neves on 23/05/16.
 */
public abstract class SimpleGfxPosition implements Position {

    private Shape shape;


    public SimpleGfxPosition(Shape shape) {
        this.shape = shape;
        shape.draw();
    }


    public Shape getShape() {
        return shape;
    }

    @Override
    public int getX() {
        return shape.getX();
    }

    @Override
    public int getY() {
        return shape.getY();
    }
}
