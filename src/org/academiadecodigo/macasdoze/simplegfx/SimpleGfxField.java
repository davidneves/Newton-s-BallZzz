package org.academiadecodigo.macasdoze.simplegfx;

import org.academiadecodigo.macasdoze.field.Field;
import org.academiadecodigo.simplegraphics.pictures.Picture;


/**
 * Created by <vi.KING_> David Neves on 23/05/16.
 */
public class SimpleGfxField implements Field {

    private int margin;
    private int height;
    private int width;
    private Picture field;


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
        field = new Picture(margin, margin,"resources/fieldBackground.png");
        field.draw();

    }


}
