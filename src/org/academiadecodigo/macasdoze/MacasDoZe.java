package org.academiadecodigo.macasdoze;

import org.academiadecodigo.macasdoze.field.Field;
import org.academiadecodigo.macasdoze.gameobjects.Apple;
import org.academiadecodigo.macasdoze.gameobjects.GameObjectsFactory;
import org.academiadecodigo.macasdoze.gameobjects.Newton;
import org.academiadecodigo.macasdoze.simplegfx.SimpleGfxMenu;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by codecadet on 23/05/16.
 */
public class MacasDoZe implements KeyboardHandler {

    public static final int HEIGHT = 900;
    public static final int WIDTH = 600;
    public static final int MARGIN = 10;
    public static final int GROUND = 50;
    public static int delay;

    private Field field;
    private GameObjectsFactory factory;
    private LinkedList<Apple> appleList;
    private AppleCollector appleCollector;
    private Newton newton;
    private SimpleGfxMenu menu;
    private Score score;
    private boolean pause;
    private boolean restart;


    public MacasDoZe(GameObjectsFactory factory, int delay) {
        this.factory = factory;
        this.delay = delay;
    }

    public void init() throws InterruptedException {
        menu = new SimpleGfxMenu();

        menu.init();
        Sound.playMenuSound();

        while (!menu.continueGame()) {
            menu.animatePlayButton();
        }

        Sound.stopSound();
        menu.clearMenu();
        gameDraw();
        start();
    }

    public void gameDraw() {

        Sound.playSound();

        score = new Score(30);
        field = factory.getPositionFactory().createField(HEIGHT, WIDTH, MARGIN, GROUND, score);
        field.init();

        newton = factory.createNewton();

        appleList = new LinkedList();
        appleCollector = new AppleCollector(newton, appleList, score);

        setKeyboard();

    }

    public void start() throws InterruptedException {

        int cycles = 0;

        while (checkGameEnd()) {

            while (pause) {
                Text gameName = new Text(300, 150, "Paused");
                gameName.setColor(Color.WHITE);
                gameName.grow(200, 60);
                gameName.draw();
                Thread.sleep(160);
                gameName.delete();
                Thread.sleep(80);
            }

            if (cycles % 80 == 0) {
                field.updateTimer();
            }

            cycles++;

            Thread.sleep(delay);
            createApple(100);

            moveApples();
            newton.move();
            appleCollector.appleCatch();

            field.displayScore();

            checkGameEnd();
        }
    }

    private void createApple(int prob) {

        if (RandomGenerator.getRandomNumber(prob) == 1) {

            appleList.add(factory.createApple());
        }
    }

    private void createBlackApple(int prob) {

        if (RandomGenerator.getRandomNumber(prob) == 1) {

            appleList.add(factory.createBlackApple());
        }
    }

    private void moveApples() {

        Iterator<Apple> it = appleList.iterator();

        while (it.hasNext()) {

            Apple apple = it.next();

            if (!apple.isFallen()) {
                apple.fall();
            }

            if (apple.getPosition().getY() > HEIGHT - GROUND) {
                apple.setFallen(true);
                apple.increaseFallenCycleCounter();

                if (apple.getFallenCycleCounter() % 240 == 0) { //3" rule
                    apple.getPosition().deleteObject();
                    it.remove();
                }
            }
        }
    }


    private boolean checkGameEnd() throws InterruptedException {

        if (score.getTimer() == 0) {
            if (score.getScore() < 250) {
                field.youLose();
                newton.getPosition().updatePicture("resources/newtonDead.png");
                newton.setAlive(false);
                endLose();

            } else {
                field.youWin();
                newton.getPosition().updatePicture("resources/newtonWin.png");
                newton.setWinner(true);
                endWin();
            }
            return false;
        }
        return true;
    }

    private void endWin() throws InterruptedException {

        Sound.stopSound();
        Sound.playVictory();

        while (true) {

            Thread.sleep(delay);

            createApple(1);
            moveApples();
            newton.move();

            if (restart) {
                clear();
                Main.main(new String[]{});
            }
        }
    }

    private void endLose() throws InterruptedException {

        Sound.stopSound();
        Sound.playGameOver();

        while (true) {

            Thread.sleep(delay);

            createBlackApple(50);
            moveApples();
            newton.move();

            if (restart) {
                clear();
                Main.main(new String[]{});
            }
        }
    }

    private void setKeyboard() {

        Keyboard k = new Keyboard(this);

        KeyboardEvent pPressedEvent = new KeyboardEvent();
        pPressedEvent.setKey(KeyboardEvent.KEY_P);
        pPressedEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(pPressedEvent);

        KeyboardEvent rPressedEvent = new KeyboardEvent();
        rPressedEvent.setKey(KeyboardEvent.KEY_R);
        rPressedEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(rPressedEvent);

    }

    private void clear() {

        Sound.stopSound();
        field.clear();
        field = null;
        factory = null;
        appleList = null;
        appleCollector = null;
        newton = null;
        menu = null;
        restart = false;
        //newton.getPosition().

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_P) {

            if (!pause) {
                pause = true;

            } else {
                pause = false;
            }
        } else if (keyboardEvent.getKey() == KeyboardEvent.KEY_R) {
            restart = true;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
