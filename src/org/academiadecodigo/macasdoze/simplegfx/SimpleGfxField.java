package org.academiadecodigo.macasdoze.simplegfx;

import org.academiadecodigo.macasdoze.Score;
import org.academiadecodigo.macasdoze.field.Field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;


/**
 * @see Field
 * <p>
 * Created by <vi.KINGS_> David Neves, Fábio Santos, Hélia Marcos and Mario Ponte on 23/05/16.
 */
public class SimpleGfxField implements Field {

    private int margin;
    private int height;
    private int width;
    private int ground;
    private Score score;
    private Text restart;

    private Picture field;
    private Text scoreText;
    private Text timerText;

    private Picture greenApple;
    private Text greenApples;

    private Picture redApple;
    private Text redApples;

    private Picture purpleApple;
    private Text purpleApples;

    private Picture blackApple;
    private Text blackApples;


    public SimpleGfxField(int height, int width, int margin, int ground, Score score) {
        this.height = height;
        this.width = width;
        this.margin = margin;
        this.ground = ground;
        this.score = score;
    }


    /**
     * @see Field#normalInit()
     */
    @Override
    public void normalInit() {

        field = new Picture(margin, margin, "resources/fieldBackground.png");
        field.draw();

        scoreText = new Text(margin, height + 2 * margin, "");
        scoreText.setColor(Color.BLACK);
        scoreText.draw();

        blackApple = new Picture(550, height + margin + 3, "resources/appleBlack3.png");
        blackApple.draw();

        blackApples = new Text(590, height + 2 * margin, "" + score.getBlackApples());
        blackApples.draw();

        purpleApple = new Picture(450, height + margin + 3, "resources/applePurple3.png");
        purpleApple.draw();

        purpleApples = new Text(490, height + 2 * margin, "" + score.getPurpleApples());
        purpleApples.draw();

        greenApple = new Picture(350, height + margin + 3, "resources/appleGreen3.png");
        greenApple.draw();

        greenApples = new Text(390, height + 2 * margin, "" + score.getGreenApples());
        greenApples.draw();

        redApple = new Picture(250, height + margin + 3, "resources/appleRed3.png");
        redApple.draw();

        redApples = new Text(290, height + 2 * margin, "" + score.getRedApples());
        redApples.draw();

        timerText = new Text(width - 2 * margin, 2 * margin, "" + score.getTimer());
        timerText.setColor(Color.WHITE);
        timerText.grow(10, 10);
        timerText.draw();

    }

    /**
     * @see Field#secretInit()
     */
    public void secretInit() {

        field = new Picture(margin, margin, "resources/fieldBackground.png");
        field.draw();

        scoreText = new Text(margin, height + 2 * margin, "");
        scoreText.setColor(Color.BLACK);
        scoreText.draw();

        redApple = new Picture(550, height + margin + 3, "resources/nuggetEaten.png");
        redApple.draw();

        redApples = new Text(590, height + 2 * margin, "" + score.getRedApples());
        redApples.draw();

        timerText = new Text(width - 2 * margin, 2 * margin, "" + score.getTimer());
        timerText.setColor(Color.WHITE);
        timerText.grow(10, 10);
        timerText.draw();

    }

    /**
     * @see Field#displayScore()
     */
    public void displayScore() {
        scoreText.setText("Newton's Score: " + score.getScore());
        purpleApples.setText("" + score.getPurpleApples());
        redApples.setText("" + score.getRedApples());
        greenApples.setText("" + score.getGreenApples());
        blackApples.setText("" + score.getBlackApples());
    }

    /**
     * @see Field#displaySecretScore()
     */
    public void displaySecretScore() {
        redApples.setText("" + score.getRedApples());
    }

    /**
     * @see Field#updateTimer()
     */
    public void updateTimer() {
        score.decreaseTimer();
        timerText.setText("" + score.getTimer());
    }

    /**
     * @see Field#youLose()
     */
    public void youLose() {
        Text youLoose = new Text(285, 150, "GAME OVER!");
        youLoose.grow(200, 60);
        youLoose.setColor(Color.RED);
        youLoose.draw();

        restart = new Text(265, 575, "Press R to restart");
        restart.grow(10, 10);
        restart.setColor(Color.WHITE);
        restart.draw();
    }

    /**
     * @see Field#youWin()
     */
    public void youWin() {
        Text youWin = new Text(300, 150, "YOU WIN!");
        youWin.grow(200, 60);
        youWin.setColor(Color.YELLOW);
        youWin.draw();

        restart = new Text(265, 575, "Press R to restart");
        restart.grow(10, 10);
        restart.setColor(Color.WHITE);
        restart.draw();
    }

    /**
     * @see Field#clearNormalMode()
     */
    public void clearNormalMode() {

        score = null;
        restart.delete();

        field.delete();
        scoreText.delete();
        timerText.delete();

        greenApple.delete();
        greenApples.delete();

        redApple.delete();
        redApples.delete();

        purpleApple.delete();
        purpleApples.delete();

        blackApple.delete();
        blackApples.delete();
    }

    /**
     * @see Field#clearSecretMode()
     */
    public void clearSecretMode() {

        score = null;
        restart.delete();

        field.delete();
        scoreText.delete();
        timerText.delete();

        redApple.delete();
        redApples.delete();

    }

}
