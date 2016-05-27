package org.academiadecodigo.macasdoze.simplegfx;

import org.academiadecodigo.macasdoze.MacasDoZe;
import org.academiadecodigo.macasdoze.RandomGenerator;
import org.academiadecodigo.macasdoze.field.Field;
import org.academiadecodigo.macasdoze.field.Position;
import org.academiadecodigo.macasdoze.field.PositionFactory;
import org.academiadecodigo.macasdoze.gameobjects.Apple;
import org.academiadecodigo.macasdoze.gameobjects.GameObjectType;

/**
 * Created by <vi.KING_> David Neves on 23/05/16.
 */
public class SimpleGfxPositionFactory implements PositionFactory {

    @Override
    public Position createPosition(GameObjectType type) {

        int x = RandomGenerator.getRandomByRange(MacasDoZe.MARGIN, MacasDoZe.WIDTH - Apple.SIZE);
        int y = RandomGenerator.getRandomByRange(MacasDoZe.MARGIN, MacasDoZe.WIDTH - MacasDoZe.GROUND);

        Position position = null;

        switch (type) {

            case NEWTON:
                position = new SimpleGfxNewton(MacasDoZe.WIDTH /2 - SimpleGfxNewton.WIDTH /2 + MacasDoZe.MARGIN, MacasDoZe.HEIGHT - SimpleGfxNewton.HEIGHT + MacasDoZe.MARGIN - MacasDoZe.GROUND);
                break;
            case RED_APPLE:
                position = new SimpleGfxRedApple(x, MacasDoZe.MARGIN);
                break;

            case GREEN_APPLE:
                position = new SimpleGfxGreenApple(x, MacasDoZe.MARGIN);
                break;
        }
        return position;
    }

    @Override
    public Field createField(int height, int width, int margin) {
        return new SimpleGfxField(height, width, margin);
    }
}
