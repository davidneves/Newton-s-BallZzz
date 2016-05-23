package org.academiadecodigo.macasdoze.gameobjects;

/**
 * Created by codecadet on 23/05/16.
 */
public interface MovableGameObject {

    int getX();
    int getY();

    public void move(int dx, int dy);

}
