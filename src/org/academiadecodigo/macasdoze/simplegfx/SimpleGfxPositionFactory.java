package org.academiadecodigo.macasdoze.simplegfx;

import org.academiadecodigo.macasdoze.field.Position;
import org.academiadecodigo.macasdoze.field.PositionFactory;
import org.academiadecodigo.macasdoze.gameobjects.GameObjectType;

/**
 * Created by <vi.KING_> David Neves on 23/05/16.
 */
public class SimpleGfxPositionFactory implements PositionFactory {

    @Override
    public Position createPosition(GameObjectType type) {

        int x = 0;
        int y = 0;

        Position position = null;

        switch (type) {

            case NEWTON:
                position = new SimpleGfxNewton(x, y);
                break;
            case RED_APPLE:
                position = new SimpleGfxRedApple(x, y);
                break;

            case GREEN_APPLE:
                position = new SimpleGfxGreenApple(x, y);
                break;
        }
        return position;
    }
}
