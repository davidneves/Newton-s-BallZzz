package org.academiadecodigo.macasdoze;

import org.academiadecodigo.macasdoze.field.PositionFactory;
import org.academiadecodigo.macasdoze.gameobjects.GameObjectsFactory;
import org.academiadecodigo.macasdoze.simplegfx.Menu;
import org.academiadecodigo.macasdoze.simplegfx.SimpleGfxPositionFactory;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;

/**
 * Created by codecadet on 23/05/16.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        PositionFactory factory = new SimpleGfxPositionFactory();

        MacasDoZe macasDoZe = new MacasDoZe(new GameObjectsFactory(factory), 10);
        Menu menu = new Menu(macasDoZe);

        menu.init();

        if(menu.continueGame()) {
            macasDoZe.start();
        }
    }

}
