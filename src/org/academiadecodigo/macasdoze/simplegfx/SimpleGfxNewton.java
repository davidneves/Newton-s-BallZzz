package org.academiadecodigo.macasdoze.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import org.academiadecodigo.simplegraphics.pictures.Picture;


/**
 * Created by <vi.KING_> David Neves on 24/05/2016.
 */
public class SimpleGfxNewton extends SimpleGfxMovablePosition {


    public static int width = 70;
    public static int height = 140;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public SimpleGfxNewton(int x, int y) {
        super(new Picture(x, y,"resources/newtonL.png"));
        //posX = x;
        //posY = y;
    }

}
