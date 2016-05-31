package org.academiadecodigo.macasdoze.simplegfx;

import org.academiadecodigo.macasdoze.MacasDoZe;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 30/05/16.
 */
public class Menu implements MouseHandler {

    private int margin;
    private int height;
    private int width;
    private boolean continueGame;


    private Picture background;
    private Picture play;
    private Text rules;
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

    public Menu() {
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

        rules = new Text(140, 140, "Get 250 points by collecting apples before the time runs out.");
        rules.setColor(Color.WHITE);
        rules.grow(20, 15);
        rules.draw();

        rules2 = new Text(190, 170, "Beware of what kind of apples you collect:");
        rules2.setColor(Color.WHITE);
        rules2.grow(10, 10);
        rules2.draw();

        redApple = new Picture(85, 220, "resources/appleRed0.png");
        redRules = new Text(130, 230, "Are worth 10 points!");
        redApple.draw();
        redRules.setColor(Color.DARK_GRAY);
        redRules.draw();

        greenApple = new Picture(345, 220, "resources/appleGreen0.png");
        greenRules = new Text(390, 230, "Are worth 20 points!");
        greenApple.draw();
        greenRules.setColor(Color.DARK_GRAY);
        greenRules.draw();

        purpleApple = new Picture(85, 270, "resources/applePurple0.png");
        purpleRules = new Text(130, 280, "Will get you 5 extra seconds!");
        purpleApple.draw();
        purpleRules.setColor(Color.DARK_GRAY);
        purpleRules.draw();

        blackApple = new Picture(345, 270, "resources/appleBlack0.png");
        blackRules = new Text(390, 280, "Makes you lose 50 points!");
        blackApple.draw();
        blackRules.setColor(Color.DARK_GRAY);
        blackRules.draw();

        play = new Picture(160, 450, "resources/playButtonWhite.png");
        play.draw();

    }

    @Override
    public void mouseClicked(MouseEvent m) {

        if (m.getEventType() == MouseEventType.MOUSE_CLICKED && (m.getX() > play.getX() && m.getX() < play.getX() + play.getWidth())
                && (m.getY() > play.getY() && m.getY() < play.getY() + play.getHeight())) {

            continueGame = true;
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {


    }

    public void clearMenu() {
        background.delete();
        play.delete();
        rules.delete();
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
    }

    public boolean continueGame() {
        return continueGame;
    }
}
