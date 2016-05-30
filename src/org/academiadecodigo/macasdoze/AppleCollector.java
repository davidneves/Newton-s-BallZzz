package org.academiadecodigo.macasdoze;

import org.academiadecodigo.macasdoze.gameobjects.Apple;
import org.academiadecodigo.macasdoze.gameobjects.GreenApple;
import org.academiadecodigo.macasdoze.gameobjects.Newton;
import org.academiadecodigo.macasdoze.gameobjects.RedApple;

import java.util.LinkedList;

/**
 * Created by codecadet on 23/05/16.
 */
public class AppleCollector {

    private Newton newton;
    private LinkedList<Apple> appleList;

    public AppleCollector(Newton newton, LinkedList<Apple> appleList) {
        this.newton = newton;
        this.appleList = appleList;
    }

    public void appleCatch() {

        if (appleList.size() != 0) {

            for (int i = 0; i < appleList.size(); i++) {
                if ((appleList.get(i).getPosition().getY() > newton.getPosition().getY()
                        && appleList.get(i).getPosition().getY() + appleList.get(i).getPosition().getHeight() < newton.getPosition().getY() + newton.getPosition().getHeight())
                        && (appleList.get(i).getPosition().getX() < newton.getPosition().getX() + newton.getPosition().getWidth()
                        && appleList.get(i).getPosition().getWidth() + appleList.get(i).getPosition().getX() > newton.getPosition().getX())) {
                    Score.increaseScore(appleList.get(i).getPoints());
                    Sound.appleCatchSound();
                    if (appleList.get(i) instanceof GreenApple) {
                        Score.increaseGreenApples();
                    } else if (appleList.get(i) instanceof RedApple) {
                        Score.increaseRedApples();
                    } else {
                        Score.increaseMegaApples();
                    }
                    appleList.get(i).getPosition().deleteObject();
                    appleList.remove(i);
                }
            }
        }
    }
}
