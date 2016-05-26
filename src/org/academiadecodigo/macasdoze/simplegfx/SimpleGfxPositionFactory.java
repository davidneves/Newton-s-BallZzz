package org.academiadecodigo.macasdoze.simplegfx;

import org.academiadecodigo.macasdoze.MacasDoZe;
import org.academiadecodigo.macasdoze.RandomGenerator;
import org.academiadecodigo.macasdoze.field.Field;
import org.academiadecodigo.macasdoze.field.Position;
import org.academiadecodigo.macasdoze.field.PositionFactory;
import org.academiadecodigo.macasdoze.gameobjects.GameObjectType;

/**
 * Created by <vi.KING_> David Neves on 23/05/16.
 */
public class SimpleGfxPositionFactory implements PositionFactory {

    @Override
    public Position createPosition(GameObjectType type) {

        int x = RandomGenerator.getRandomNumber(MacasDoZe.width);
        int y = RandomGenerator.getRandomNumber(MacasDoZe.height);

        Position position = null;

        switch (type) {

            case NEWTON:
                position = new SimpleGfxNewton(MacasDoZe.width/2, 20);
                break;
            case RED_APPLE:
                position = new SimpleGfxRedApple(0, y);
                break;

            case GREEN_APPLE:
                position = new SimpleGfxGreenApple(0, y);
                break;
        }
        return position;
    }

    @Override
    public Field createField(int height, int width) {
        return new SimpleGfxField(height, width);
    }
}
