package org.academiadecodigo.macasdoze.field;

/**
 * Created by <vi.KING_> David Neves on 23/05/16.
 */
public interface Field {

    void init();

    int getX();

    int getY();

    Position createPosition();

    Position createRandomTopPosition();
}
