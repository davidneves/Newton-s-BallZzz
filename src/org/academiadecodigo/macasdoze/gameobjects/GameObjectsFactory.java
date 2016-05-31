package org.academiadecodigo.macasdoze.gameobjects;

import org.academiadecodigo.macasdoze.RandomGenerator;
import org.academiadecodigo.macasdoze.field.MovablePosition;
import org.academiadecodigo.macasdoze.field.PositionFactory;

/**
 * Created by codecadet on 23/05/16.
 */

public class GameObjectsFactory {

    private PositionFactory positionFactory;


    public GameObjectsFactory(PositionFactory positionFactory) {
        this.positionFactory = positionFactory;
    }


    public PositionFactory getPositionFactory() {
        return positionFactory;
    }

    public Apple createApple() {

        int probBlackApple = 10;
        int probPurpleApple = 20;
        int probGreenApple = 55;

        int randomGen = RandomGenerator.getRandomByRange(0, 100);

        Apple apple = null;

        if (randomGen < probBlackApple) {
            apple = new BlackApple((MovablePosition) positionFactory.createPosition(GameObjectType.BLACK_APPLE), 6, -50);
        } else if (randomGen < probPurpleApple) {
            apple = new PurpleApple((MovablePosition) positionFactory.createPosition(GameObjectType.PURPLE_APPLE), 5, 0, 5);
        } else if (randomGen < probGreenApple) {
            apple = new GreenApple((MovablePosition) positionFactory.createPosition(GameObjectType.GREEN_APPLE), 4, 20);
        } else {
            apple = new RedApple((MovablePosition) positionFactory.createPosition(GameObjectType.RED_APPLE), 2, 10);
        }

        return apple;
    }

    public Apple createBlackApple() {

        return new BlackApple((MovablePosition) positionFactory.createPosition(GameObjectType.BLACK_APPLE), 4, 0);
    }

    public Newton createNewton() {

        Newton newton = new Newton((MovablePosition) positionFactory.createPosition(GameObjectType.NEWTON));
        return newton;
    }

}
