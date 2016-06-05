package org.academiadecodigo.macasdoze.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Shape;

/**
 * Instatiated in SimpleGfxPositionFactory
 *
 * @see SimpleGfxMovablePosition
 *
 * Created by <vi.KINGS_> David Neves, Fábio Santos, Hélia Marcos and Mário Ponte on 24/05/2016.
 */
public abstract class SimpleGfxApple extends SimpleGfxMovablePosition {

    public static final int SIZE = 30;

    public SimpleGfxApple(Shape shape) {
        super(shape);
    }

    @Override
    public int getWidth() {
        return SIZE;
    }

    @Override
    public int getHeight() {
        return SIZE;
    }
}
