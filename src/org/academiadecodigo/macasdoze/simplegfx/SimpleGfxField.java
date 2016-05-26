package org.academiadecodigo.macasdoze.simplegfx;

import org.academiadecodigo.macasdoze.field.Field;
import org.academiadecodigo.macasdoze.field.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by <vi.KING_> David Neves on 23/05/16.
 */
public class SimpleGfxField implements Field {

    private int margin;
    private int height;
    private int width;
    private Rectangle field;


    public SimpleGfxField(int height, int width, int margin) {
        this.height = height;
        this.width = width;
        this.margin =  margin;
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
        field = new Rectangle(margin, margin, width, height);
        field.draw();

    }


}
