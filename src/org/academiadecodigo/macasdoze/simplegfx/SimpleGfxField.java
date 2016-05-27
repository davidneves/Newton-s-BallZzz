package org.academiadecodigo.macasdoze.simplegfx;

import org.academiadecodigo.macasdoze.field.Field;
import org.academiadecodigo.macasdoze.Score;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;


/**
 * Created by <vi.KING_> David Neves on 23/05/16.
 */
public class SimpleGfxField implements Field {

    private int margin;
    private int height;
    private int width;
    private int ground;
    private Picture field;
    private Text score;


    public SimpleGfxField(int height, int width, int margin, int ground) {
        this.height = height;
        this.width = width;
        this.margin =  margin;
        this.ground = ground;
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
        score = new Text(margin, height+margin, "");
        score.setColor(Color.BLACK);
        score.draw();
    }

    public void displayScore() {
        score.setText("Newton's SCORE: " + Score.score);
    }




}
