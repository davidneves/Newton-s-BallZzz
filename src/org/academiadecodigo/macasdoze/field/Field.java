package org.academiadecodigo.macasdoze.field;

/**
 * Created by codecadet on 23/05/16.
 */
public interface Field {

    int getHeight();

    int getWidth();

    void init();

    void displayScore();

    void youLoose();

    void youWin();

    void updateTimer();

    int getTimer();

    void increaseTimer(int n);

}
