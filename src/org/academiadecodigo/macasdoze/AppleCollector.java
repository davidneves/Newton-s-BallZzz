package org.academiadecodigo.macasdoze;

import org.academiadecodigo.macasdoze.gameobjects.Apple;
import org.academiadecodigo.macasdoze.gameobjects.Newton;

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

        for (int i = 0; i < appleList.size(); i++) {
            if (appleList.get(i).getPosition().equals(newton.getPosition())){
                //appleList.get(i).
                //newton.
            }
        }

    }
}
