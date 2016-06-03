package org.academiadecodigo.macasdoze.simplegfx;

import org.academiadecodigo.simplegraphics.pictures.Picture;


/**
 * Created by <vi.KING_> David Neves on 24/05/2016.
 */
public class SimpleGfxNewton extends SimpleGfxMovablePosition {


    public static final int WIDTH = 70;
    public static final int HEIGHT = 117;


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