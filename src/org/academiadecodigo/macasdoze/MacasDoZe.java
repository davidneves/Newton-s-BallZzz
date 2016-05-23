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
    private int delay;
    private Display display;
    public static final int height = 1200;
    public static final int width = 500;

    private AppleFactory factory;
    private Apple[] apples;
    private AppleCollector appleCollector;
    private Newton newton;

    public MacasDoZe(AppleFactory factory, int numObjects, int delay) {
        this.factory = factory;
        this.numObjects = numObjects;
        this.delay = delay;
        display = new Display(height, width);
    }

    public void start(){

        apples = new Apple[numObjects];
        appleCollector = new AppleCollector();




    }
}
