package org.academiadecodigo.macasdoze.gameobjects;

import org.academiadecodigo.macasdoze.field.PositionFactory;

/**
 * Created by codecadet on 23/05/16.
 */

public class AppleFactory {

    private PositionFactory positionFactory;

    public AppleFactory(PositionFactory positionFactory) {
        this.positionFactory = positionFactory;
    }

    public Apple createApple(AppleType type) {


        Apple apple = null;

        switch (type) {

            case RED:
                apple = new Red(positionFactory.createPosition);
                break;

            case GREEN:
                apple = new Green();
                break;

        }
        return apple;
    }

}
