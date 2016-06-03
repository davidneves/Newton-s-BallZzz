package org.academiadecodigo.macasdoze.simplegfx;

import org.academiadecodigo.macasdoze.MacasDoZe;
import org.academiadecodigo.macasdoze.field.Menu;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 30/05/16.
 */
public class SimpleGfxMenu implements Menu, MouseHandler {

    private int margin;
    private int height;
    private int width;
    private boolean continueGame;
    private boolean normalMode = true;


    private Picture background;
    private Picture play;
    private Text rules;
    private Text rules1;
    private Text rules2;
    private Picture redApple;
    private Picture greenApple;
    private Picture purpleApple;
    private Picture blackApple;
    private Text redRules;
    private Text greenRules;
    private Text purpleRules;
    private Text blackRules;
    private Text gameName;
    private Text credits;

    public SimpleGfxMenu() {
        margin = MacasDoZe.MARGIN;
        height = MacasDoZe.HEIGHT;
        width = MacasDoZe.WIDTH;
    }

    public void init() {

        Mouse m = new Mouse(this);

        m.addEventListener(MouseEventType.MOUSE_CLICKED);
        m.addEventListener(MouseEventType.MOUSE_MOVED);

        background = new Picture(margin, margin, "resources/fieldBackground.png");
        background.draw();

        gameName = new Text(265, 60, "NEWTON'S BALLS");
        gameName.setColor(Color.WHITE);
        gameName.grow(220, 50);
        gameName.draw();

        rules = new Text(140, 130, "Get 250 points by collecting apples before the time runs out.");
        rules.setColor(Color.WHITE);
        rules.grow(20, 15);
        rules.draw();

        rules1 = new Text(145, 163, "Use the ARROWS to move, SPACE to jump and P to pause.");
        rules1.setColor(Color.WHITE);
        rules1.grow(9, 8);
        rules1.draw();

        rules2 = new Text(190, 200, "Beware of what kind of apples you collect:");
        rules2.setColor(Color.WHITE);
        rules2.grow(10, 9);
        rules2.draw();

        redApple = new Picture(85, 240, "resources/appleRed0.png");
        redRules = new Text(130, 250, "Are worth 10 points!");
        redApple.draw();
        redRules.setColor(Color.DARK_GRAY);
        redRules.draw();

        greenApple = new Picture(345, 240, "resources/appleGreen0.png");
        greenRules = new Text(390, 250, "Are worth 20 points!");
        greenApple.draw();
        greenRules.setColor(Color.DARK_GRAY);
        greenRules.draw();

        purpleApple = new Picture(85, 290, "resources/applePurple0.png");
        purpleRules = new Text(130, 300, "Will get you 5 extra seconds!");
        purpleApple.draw();
        purpleRules.setColor(Color.DARK_GRAY);
        purpleRules.draw();

        blackApple = new Picture(345, 290, "resources/appleBlack0.png");
        blackRules = new Text(390, 300, "Makes you lose 50 points!");
        blackApple.draw();
        blackRules.setColor(Color.DARK_GRAY);
        blackRules.draw();

        play = new Picture(160, 450, "resources/playButton1.png");
        play.draw();

        credits = new Text(30, height - 40, "A <vi_KING> game by:   David Neves   Fábio Santos   Hélia Marcos   Mário Ponte");
        credits.setColor(Color.BLUE);
        credits.draw();

    }

    public void animatePlayButton() throws InterruptedException {
        play.load("resources/playButton1.png");
        Thread.sleep(125);
        play.load("resources/playButton2.png");
        Thread.sleep(125);
        play.load("resources/playButton3.png");
        Thread.sleep(125);
        play.load("resources/playButton4.png");
        Thread.sleep(125);
    }

    public void clearMenu() {

        background.delete();
        play.delete();
        rules.delete();
        rules1.delete();
        rules2.delete();
        redApple.delete();
        greenApple.delete();
        purpleApple.delete();
        blackApple.delete();
        redRules.delete();
        greenRules.delete();
        purpleRules.delete();
        blackRules.delete();
        gameName.delete();
        credits.delete();
    }

    public boolean continueGame() {
        return continueGame;
    }

    @Override
    public void mouseClicked(MouseEvent m) {

        if (m.getEventType() == MouseEventType.MOUSE_CLICKED && (m.getX() > play.getX() && m.getX() < play.getX() + play.getWidth())
                && (m.getY() > play.getY() && m.getY() < play.getY() + play.getHeight())) {

            continueGame = true;
        } else if (m.getEventType() == MouseEventType.MOUSE_CLICKED && (m.getX() > bird.getX() && m.getX() < bird.getX() + bird.getWidth())
                && (m.getY() > bird.getY() && m.getY() < bird.getY() + bird.getHeight())) {
            normalMode = false;
            continueGame = true;
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
    }

    public boolean isNormalMode() {
        return normalMode;
    }
}
