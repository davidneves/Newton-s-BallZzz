package org.academiadecodigo.macasdoze.simplegfx;

import org.academiadecodigo.macasdoze.Score;
import org.academiadecodigo.macasdoze.field.Field;
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
    private int timer = 30;
    private Text timerText;

    private Picture greenApple;
    private Text greenApples;
    private Picture redApple;
    private Text redApples;
    private Picture megaApple;
    private Text megaApples;


    public SimpleGfxField(int height, int width, int margin, int ground) {
        this.height = height;
        this.width = width;
        this.margin = margin;
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

    public int getTimer() {
        return timer;
    }

    @Override
    public void init() {

        field = new Picture(margin, margin, "resources/fieldBackground.png");
        field.draw();

        score = new Text(margin, height + 2 * margin, "");
        score.setColor(Color.BLACK);
        score.draw();

        megaApple = new Picture(550, height + margin, "resources/applePurple3.png");
        megaApple.draw();

        megaApples = new Text(590, height + 2 * margin, "" + Score.megaApples);
        megaApples.draw();

        greenApple = new Picture(450, height + margin, "resources/appleGreen3.png");
        greenApple.draw();

        greenApples = new Text(490, height + 2 * margin, "" + Score.greenApples);
        greenApples.draw();

        redApple = new Picture(350, height + margin, "resources/appleRed3.png");
        redApple.draw();

        redApples = new Text(390, height + 2 * margin, "" + Score.redApples);
        redApples.draw();

        timerText = new Text(width - 2 * margin, margin * 2, "" + timer);
        timerText.setColor(Color.WHITE);
        timerText.grow(10, 10);
        timerText.draw();

    }

    public void displayScore() {
        score.setText("Newton's Score: " + Score.score);
        megaApples.setText("" + Score.megaApples);
        redApples.setText("" + Score.redApples);
        greenApples.setText("" + Score.greenApples);
    }

    public void updateTimer() {
        timer--;
        timerText.setText("" + timer);
    }

    public void youLoose() {
        Text youLoose = new Text(285, 150, "GAME OVER!");
        youLoose.grow(200, 60);
        youLoose.setColor(Color.RED);
        youLoose.draw();
    }

    public void youWin() {
        Text youWin = new Text(300, 150, "YOU WIN!");
        youWin.grow(200, 60);
        youWin.setColor(Color.YELLOW);
        youWin.draw();
    }

}
