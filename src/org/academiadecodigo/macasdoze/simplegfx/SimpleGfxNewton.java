package org.academiadecodigo.macasdoze.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import org.academiadecodigo.simplegraphics.pictures.Picture;


/**
 * Created by <vi.KING_> David Neves on 24/05/2016.
 */
public class SimpleGfxNewton extends SimpleGfxMovablePosition {


    int posX;
    int posY;
    Rectangle newton = new Rectangle(posX, posY, 70, 140);



    public SimpleGfxNewton(int x, int y) {
        super(new Picture(x, y));
        posX = x;
        posY = y;
    }

}
