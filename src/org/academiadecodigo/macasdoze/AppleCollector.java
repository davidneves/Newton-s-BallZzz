package org.academiadecodigo.macasdoze;

import org.academiadecodigo.macasdoze.gameobjects.*;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by codecadet on 23/05/16.
 */
public class AppleCollector {

    private Newton newton;
    private LinkedList<Apple> appleList;
    private Score score;

    public AppleCollector(Newton newton, LinkedList<Apple> appleList, Score score) {
        this.newton = newton;
        this.appleList = appleList;
        this.score = score;
    }

    public void appleCatch() {

        Apple apple = null;
        Iterator<Apple> it = appleList.iterator();
        while (it.hasNext()) {

            apple = it.next();

            if (apple.getPosition().getY() > newton.getPosition().getY()
                    && apple.getPosition().getY() + apple.getPosition().getHeight() < newton.getPosition().getY() + newton.getPosition().getHeight()
                    && (apple.getPosition().getX() < newton.getPosition().getX() + newton.getPosition().getWidth()
                    && apple.getPosition().getWidth() + apple.getPosition().getX() > newton.getPosition().getX())) {

                score.increaseScore(apple.getPoints());
                Sound.appleCatchSound();

                if (apple instanceof GreenApple) {
                    score.increaseGreenApples();
                } else if (apple instanceof RedApple) {
                    score.increaseRedApples();
                } else if (apple instanceof PurpleApple) {
                    score.increasePurpleApples();
                    score.increaseTimer(((PurpleApple) apple).getTimeBoost());
                } else {
                    score.increaseBlackApples();
                }

                apple.getPosition().deleteObject();
                it.remove();

            }
        }
    }
}
