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

        field = factory.getPositionFactory().createField(HEIGHT, WIDTH, MARGIN, GROUND);
        field.init();


        newton = factory.createNewton();

        appleList = new LinkedList();
        appleCollector = new AppleCollector(newton, appleList);

    }

    public void start() throws InterruptedException {


        while (true) {

            Thread.sleep(delay);
            if (RandomGenerator.getRandomNumber(100) == 5) {

                appleList.add(factory.createApple());
            }

            for (int i = 0; i < appleList.size(); i++) {
                if (!appleList.get(i).isFallen()) {
                    appleList.get(i).fall();
                }

                if (appleList.get(i).getPosition().getY() > HEIGHT - GROUND) {
                    appleList.get(i).setFallen(true);
                    appleList.get(i).increaseFallenCycleCounter();
                    if (appleList.get(i).getFallenCycleCounter() % 240 == 0) { //3" rule
                        appleList.get(i).getPosition().deleteObject();
                        appleList.remove(i);
                    }
                }
            }
            newton.move();
            appleCollector.appleCatch();

            field.displayScore();

        }

    }


}
