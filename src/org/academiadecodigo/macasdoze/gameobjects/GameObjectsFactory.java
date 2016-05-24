package org.academiadecodigo.macasdoze.gameobjects;

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

    public Apple createApple(GameObjectType type) {


        Apple apple = null;

        switch (type) {

            case RED_APPLE:
                apple = new RedApple((MovablePosition) positionFactory.createPosition(type));
                break;

            case GREEN_APPLE:
                apple = new GreenApple((MovablePosition) positionFactory.createPosition(type));
                break;
        }
        return apple;
    }

    public Newton createNewton() {

        Newton newton = new Newton((MovablePosition) positionFactory.createPosition(GameObjectType.NEWTON));
        return newton;
    }

}
