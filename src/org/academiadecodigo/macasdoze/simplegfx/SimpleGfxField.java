package org.academiadecodigo.macasdoze.simplegfx;

import org.academiadecodigo.macasdoze.field.Field;
import org.academiadecodigo.macasdoze.field.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by <vi.KING_> David Neves on 23/05/16.
 */
public class SimpleGfxField implements Field {

    private static final int MARGIN = 10;
    private int height;
    private int width;
    private Rectangle field;


    public SimpleGfxField(int height, int width) {
        this.height = height;
        this.width = width;
    }


    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }


    @Override
    public void init() {
        field = new Rectangle(MARGIN, MARGIN, width, height);
        field.draw();

    }


}
