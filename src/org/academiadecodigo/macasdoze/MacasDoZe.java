package org.academiadecodigo.macasdoze;

import org.academiadecodigo.macasdoze.field.Field;
import org.academiadecodigo.macasdoze.gameobjects.Apple;
import org.academiadecodigo.macasdoze.gameobjects.GameObjectsFactory;
import org.academiadecodigo.macasdoze.gameobjects.Newton;
import org.academiadecodigo.macasdoze.simplegfx.SimpleGfxMenu;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by codecadet on 23/05/16.
 */
public class MacasDoZe {

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


    public MacasDoZe(GameObjectsFactory factory, int delay) {
        this.factory = factory;
        this.delay = delay;
    }

    public void init() throws InterruptedException {
        menu = new SimpleGfxMenu();

        menu.init();
        Sound.playMenuSound();
        while (!menu.continueGame()){
            Thread.sleep(delay);
        }
        Sound.stopSound();
        menu.clearMenu();
        gameDraw();
        start();
    }

    public void gameDraw(){

        Sound.playSound();

        field = factory.getPositionFactory().createField(HEIGHT, WIDTH, MARGIN, GROUND);
        field.init();

        newton = factory.createNewton();

        appleList = new LinkedList();
        appleCollector = new AppleCollector(newton, appleList);

    }

    public void start() throws InterruptedException {

        int cycles = 0;

        while (checkGameEnd()) {

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
                    Score.increaseRottenApples();
                    apple.getPosition().deleteObject();
                    it.remove();
                }
            }
        }
    }


    private boolean checkGameEnd() throws InterruptedException {

        if (Score.rottenApples > 30) {
            field.youLose();
            Sound.stopSound();
            return false;
        }

        if (Score.timer == 0) {
            if (Score.score < 250) {
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
        }
    }
}
