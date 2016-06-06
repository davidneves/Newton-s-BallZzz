package org.academiadecodigo.macasdoze.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Shape;

/**
 * Instatiated in SimpleGfxPositionFactory
 *
 * @see SimpleGfxMovablePosition
 *
 * Created by vi.KINGS David Neves, Fabio Santos, Helia Marcos and Mario Ponte on 23/05/16.
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
