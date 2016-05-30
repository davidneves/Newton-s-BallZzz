package org.academiadecodigo.macasdoze;

import org.academiadecodigo.macasdoze.field.Field;
import org.academiadecodigo.macasdoze.gameobjects.Apple;
import org.academiadecodigo.macasdoze.gameobjects.GameObjectsFactory;
import org.academiadecodigo.macasdoze.gameobjects.Newton;

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

    private boolean keepPlaying = true;
    private Field field;
    private GameObjectsFactory factory;
    private LinkedList<Apple> appleList;
    private AppleCollector appleCollector;
    private Newton newton;


    public MacasDoZe(GameObjectsFactory factory, int delay) {
        this.factory = factory;
        this.delay = delay;
    }


    public void init() {

        Sound.playSound();

        field = factory.getPositionFactory().createField(HEIGHT, WIDTH, MARGIN, GROUND);
        field.init();

        newton = factory.createNewton();

        appleList = new LinkedList();
        appleCollector = new AppleCollector(newton, appleList);

    }

    public void start() throws InterruptedException {

        int cycles = 0;

        while (keepPlaying) {

            if (cycles % 80 == 0) {
                field.updateTimer();
            }

            cycles++;

            Thread.sleep(delay);
            if (RandomGenerator.getRandomNumber(100) == 5) {

                appleList.add(factory.createApple());
            }

            for (int i = 0; i < appleList.size(); i++) {

                Apple apple = appleList.get(i);

                if (!apple.isFallen()) {
                    apple.fall();
                }

                if (apple.getPosition().getY() > HEIGHT - GROUND) {
                    apple.setFallen(true);
                    apple.increaseFallenCycleCounter();
                    if (apple.getFallenCycleCounter() % 240 == 0) { //3" rule
                        Score.increaseRottenApples();
                        apple.getPosition().deleteObject();
                        appleList.remove(i);
                    }
                }

                if (Score.rottenApples > 30) {
                    field.youLoose();
                    keepPlaying = false;
                    Sound.stopSound();
                }
            }
            newton.move();
            appleCollector.appleCatch();

            field.displayScore();

            if (field.getTimer() == 0) {
                if (Score.score < 200) {
                    field.youLoose();
                } else {
                    field.youWin();
                    end();
                }
                keepPlaying = false;
                Sound.stopSound();
            }
        }
    }

    public void end() throws InterruptedException {

        while (true) {

            Thread.sleep(delay);

            appleList.add(factory.createApple());

            for (int i = 0; i < appleList.size(); i++) {

                Apple apple = appleList.get(i);

                if (!apple.isFallen()) {
                    apple.fall();
                }

                if (apple.getPosition().getY() > HEIGHT - GROUND) {
                    apple.setFallen(true);
                    apple.increaseFallenCycleCounter();
                    if (apple.getFallenCycleCounter() % 80 == 0) { //1" rule
                        apple.getPosition().deleteObject();
                        appleList.remove(i);
                    }
                }
            }
        }
    }
}
