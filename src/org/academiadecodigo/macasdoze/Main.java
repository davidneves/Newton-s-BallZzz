package org.academiadecodigo.macasdoze;

import org.academiadecodigo.macasdoze.field.PositionFactory;
import org.academiadecodigo.macasdoze.gameobjects.GameObjectsFactory;
import org.academiadecodigo.macasdoze.simplegfx.SimpleGfxPositionFactory;

/**
 * Created by codecadet on 23/05/16.
 */
public class Main {

    public static void main(String[] args) {

        PositionFactory factory = new SimpleGfxPositionFactory();

        MacasDoZe macasDoZe = new MacasDoZe( new GameObjectsFactory(factory), 30, 150);

        macasDoZe.start();

    }
}
