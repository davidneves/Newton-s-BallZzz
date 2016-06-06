package org.academiadecodigo.macasdoze.simplegfx;

import org.academiadecodigo.simplegraphics.pictures.Picture;


/**
 * Instatiated in SimpleGfxPositionFactory
 *
 * @see SimpleGfxMovablePosition
 *
 * Created by vi.KINGS David Neves, Fabio Santos, Helia Marcos and Mario Ponte on 23/05/16.
 */
public class SimpleGfxNewton extends SimpleGfxMovablePosition {


    public static final int WIDTH = 70;
    public static final int HEIGHT = 117;


    /**
     * Creates a new picture and defines its path.
     * @param x
     * @param y
     */
    public SimpleGfxNewton(int x, int y) {
        super(new Picture(x, y, "resources/newtonStillL.png"));

    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }


}