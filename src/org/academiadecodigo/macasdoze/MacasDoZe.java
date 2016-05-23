package org.academiadecodigo.macasdoze;

import org.academiadecodigo.macasdoze.field.Display;
import org.academiadecodigo.macasdoze.gameobjects.Apple;
import org.academiadecodigo.macasdoze.gameobjects.AppleFactory;
import org.academiadecodigo.macasdoze.gameobjects.Newton;

/**
 * Created by codecadet on 23/05/16.
 */
public class MacasDoZe {

    private int numObjects;
    private Apple[] apples;
    private int delay;
    private Newton newton;
    private AppleFactory factory;
    private Display display;

    public MacasDoZe(int numObjects, int delay) {
        this.numObjects = numObjects;
        this.delay = delay;
        display = new Display(1200, 500);
    }

    public void start(){

        apples = new Apple[numObjects];


    }
}
