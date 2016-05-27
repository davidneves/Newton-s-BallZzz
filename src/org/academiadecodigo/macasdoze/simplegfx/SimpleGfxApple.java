package org.academiadecodigo.macasdoze.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Shape;

/**
 * Created by <vi.KING_> David Neves on 24/05/2016.
 */
public abstract class SimpleGfxApple extends SimpleGfxMovablePosition {

    public static final int SIZE = 30;

    @Override
    public int getWidth() {
        return SIZE;
    }

    @Override
    public int getHeight() {
        return SIZE;
    }

    public SimpleGfxApple(Shape shape) {

        super(shape);
    }
}
