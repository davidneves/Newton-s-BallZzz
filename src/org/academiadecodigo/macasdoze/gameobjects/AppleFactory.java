package org.academiadecodigo.macasdoze.gameobjects;

import org.academiadecodigo.macasdoze.RandomGenerator;

/**
 * Created by codecadet on 23/05/16.
 */

public class AppleFactory {

    public static Apple createApple() {

        int randomApple = RandomGenerator.getRandomNumber(AppleType.values().length - 1);
        AppleType appleType = AppleType.values()[randomApple];
        Apple apple = null;

        switch (appleType) {

            case RED:
                apple = new Red();
                break;

            case GREEN:
                apple = new Green();
                break;

        }
        return apple;
    }

}
