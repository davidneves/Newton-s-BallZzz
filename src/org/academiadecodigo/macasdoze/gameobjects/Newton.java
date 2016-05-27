package org.academiadecodigo.macasdoze.gameobjects;

import org.academiadecodigo.macasdoze.AppleCollector;
import org.academiadecodigo.macasdoze.MacasDoZe;
import org.academiadecodigo.macasdoze.field.Position;
import org.academiadecodigo.macasdoze.simplegfx.SimpleGfxNewton;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by codecadet on 23/05/16.
 */
public class Newton extends  MovableGameObject implements KeyboardHandler{


    private int points = 0;
    private final int speed = 5;

    private Keyboard k;
    private boolean leftPressed;
    private boolean rightPressed;
    private AppleCollector appleCollector;

    public Newton(Position position, AppleCollector appleCollector) {
        super(position);
        setKeyboard();
        this.appleCollector = appleCollector;
    }

    public int getPoints() {
        return points;
    }

    public void increasePoints(int points) {
        this.points += points;
    }


    public void move() {
        if (leftPressed == true && this.getPosition().getX()> MacasDoZe.MARGIN) {
            for (int i = 0; i < speed; i++) {
                super.move(-1, 0);
            }

        }
        if (rightPressed == true && this.getPosition().getX()< (MacasDoZe.WIDTH + MacasDoZe.MARGIN - SimpleGfxNewton.WIDTH)) {
            for (int i = 0; i < speed; i++) {
                super.move(1, 0);
            }
        }
        //appleCollector.appleCatch();
    }


    public void setKeyboard() {

        k = new Keyboard(this);

        Keyboard k = new Keyboard(this);

        KeyboardEvent leftPressedEvent = new KeyboardEvent();
        leftPressedEvent.setKey(KeyboardEvent.KEY_LEFT);
        leftPressedEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(leftPressedEvent);

        KeyboardEvent rightPressedEvent = new KeyboardEvent();
        rightPressedEvent.setKey(KeyboardEvent.KEY_RIGHT);
        rightPressedEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(rightPressedEvent);


        KeyboardEvent leftReleasedEvent = new KeyboardEvent();
        leftReleasedEvent.setKey(KeyboardEvent.KEY_LEFT);
        leftReleasedEvent.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        k.addEventListener(leftReleasedEvent);

        KeyboardEvent rightReleasedEvent = new KeyboardEvent();
        rightReleasedEvent.setKey(KeyboardEvent.KEY_RIGHT);
        rightReleasedEvent.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        k.addEventListener(rightReleasedEvent);

    }

    @Override
    public void keyPressed(KeyboardEvent e) {

        if (e.getKey() == KeyboardEvent.KEY_LEFT) {
            leftPressed = true;
            getPosition().updatePicture("resources/newtonL.png");
        } else if (e.getKey() == KeyboardEvent.KEY_RIGHT) {
            rightPressed = true;
            getPosition().updatePicture("resources/newtonR.png");
        }





    }

    @Override
    public void keyReleased(KeyboardEvent e) {

        if (e.getKey() == KeyboardEvent.KEY_LEFT) {
            leftPressed = false;
        } else if (e.getKey() == KeyboardEvent.KEY_RIGHT) {
            rightPressed = false;
        }

    }
}
