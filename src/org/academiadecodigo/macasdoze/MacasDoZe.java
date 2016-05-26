package org.academiadecodigo.macasdoze;

import org.academiadecodigo.macasdoze.field.Field;
import org.academiadecodigo.macasdoze.gameobjects.Apple;
import org.academiadecodigo.macasdoze.gameobjects.GameObjectType;
import org.academiadecodigo.macasdoze.gameobjects.GameObjectsFactory;
import org.academiadecodigo.macasdoze.gameobjects.Newton;

import java.util.LinkedList;

/**
 * Created by codecadet on 23/05/16.
 */
public class MacasDoZe {

    public static int delay;
    private Field field;
    public static final int HEIGHT = 900;
    public static final int WIDTH = 600;
    public static final int MARGIN = 10;

    private GameObjectsFactory factory;
    private LinkedList<Apple> appleList;
    private AppleCollector appleCollector;
    private Newton newton;


    public MacasDoZe(GameObjectsFactory factory, int delay) {
        this.factory = factory;
        this.delay = delay;
    }


    public void init(){

        field = factory.getPositionFactory().createField(HEIGHT, WIDTH, MARGIN);
        field.init();

        appleCollector = new AppleCollector(newton, appleList);

        newton = factory.createNewton();

        LinkedList objectList = new LinkedList();


    }

    public void start() throws InterruptedException {

        GameObjectType randomGameObject;

        while (true) {

            Thread.sleep(delay);

            /*randomGameObject = GameObjectType.values()[RandomGenerator.getRandomByRange(1, GameObjectType.values().length - 1)];

            appleList.add(factory.createApple(randomGameObject));

            for (int i = 0; i < appleList.size(); i++) {
                appleList.get(i).fall();
            }*/

            newton.move();


        }

    }
}
