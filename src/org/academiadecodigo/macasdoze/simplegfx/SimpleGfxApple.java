package org.academiadecodigo.macasdoze.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Shape;

/**
 * Created by <vi.KING_> David Neves on 24/05/2016.
 */
public abstract class SimpleGfxApple extends SimpleGfxMovablePosition {


    private int width = 30;
    private int height = 30;

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public SimpleGfxApple(Shape shape) {

        super(shape);
    }
}
