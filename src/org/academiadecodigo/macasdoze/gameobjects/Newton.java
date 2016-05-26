package org.academiadecodigo.macasdoze.gameobjects;

import org.academiadecodigo.macasdoze.field.Position;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by codecadet on 23/05/16.
 */
public class Newton extends  MovableGameObject implements KeyboardHandler{

    private Keyboard k;
    private boolean leftPressed;
    private boolean rightPressed;


    public Newton(Position position) {
        super(position);
    }

/*
    public void moveLeft(int dx) {
        super.move( -dx, 0);
    }

    public void moveRight(int dx) {
        super.move(dx, 0);
    }*/

    public void move() {
        while (leftPressed == true) {
            super.move(-1,0);
        }
        while (rightPressed == true) {
            super.move(1,0);
        }
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
        } else if (e.getKey() == KeyboardEvent.KEY_RIGHT) {
            rightPressed = true;
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
