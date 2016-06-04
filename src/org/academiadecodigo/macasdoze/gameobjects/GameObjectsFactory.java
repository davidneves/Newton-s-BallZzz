package org.academiadecodigo.macasdoze.gameobjects;

import org.academiadecodigo.macasdoze.RandomGenerator;
import org.academiadecodigo.macasdoze.field.MovablePosition;
import org.academiadecodigo.macasdoze.field.PositionFactory;

/**
 * To be instantiated by MacasDoZe class.
 * <p>
 * Creates the different types of Game Objects.
 * <p>
 * Created by <vi.KINGS_> David Neves, Fábio Santos, Hélia Marcos and Mário Ponte on 23/05/16.
 */

public class GameObjectsFactory {

    private PositionFactory positionFactory;


    public GameObjectsFactory(PositionFactory positionFactory) {
        this.positionFactory = positionFactory;
    }


    public PositionFactory getPositionFactory() {
        return positionFactory;
    }

    /**
     * Generates apples.
     * <p>
     * It has different probabilities to create each type of apple.
     * <p>
     *
     * @return a Apple
     */
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

    /**
     * @return a new Black Apple
     */
    public Apple createBlackApple() {

        return new BlackApple((MovablePosition) positionFactory.createPosition(GameObjectType.BLACK_APPLE), 4, 0);
    }

    /**
     * @return the player Game Object Newton
     */
    public Newton createNewton() {

        Newton newton = new Newton((MovablePosition) positionFactory.createPosition(GameObjectType.NEWTON));
        return newton;
    }

    /**
     * @return new Game Object of the Secret Level
     */
    public Apple createNugget() {
        return new RedApple((MovablePosition) positionFactory.createPosition(GameObjectType.NUGGET), 5, 20);
    }

}
