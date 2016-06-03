package org.academiadecodigo.macasdoze.simplegfx;

import org.academiadecodigo.macasdoze.MacasDoZe;
import org.academiadecodigo.macasdoze.RandomGenerator;
import org.academiadecodigo.macasdoze.Score;
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

        int x = RandomGenerator.getRandomByRange(MacasDoZe.MARGIN, MacasDoZe.WIDTH - SimpleGfxApple.SIZE);
        int y = MacasDoZe.MARGIN;

        Position position = null;

        switch (type) {

            case NEWTON:
                position = new SimpleGfxNewton(MacasDoZe.WIDTH / 2 - SimpleGfxNewton.WIDTH / 2 + MacasDoZe.MARGIN, MacasDoZe.HEIGHT - SimpleGfxNewton.HEIGHT + MacasDoZe.MARGIN - MacasDoZe.GROUND);
                break;
            case RED_APPLE:
                position = new SimpleGfxRedApple(x, y, "resources/appleRed00.png");
                break;

            case GREEN_APPLE:
                position = new SimpleGfxGreenApple(x, y, "resources/appleGreen00.png");
                break;

            case PURPLE_APPLE:
                position = new SimpleGfxPurpleApple(x, y, "resources/applePurple00.png");
                break;
            case BLACK_APPLE:
                position = new SimpleGfxBlackApple(x, y, "resources/appleBlack00.png");
                break;
            case NUGGET:
                position = new SimpleGfxRedApple(x, y, "resources/nugget.png");
        }
        return position;
    }

    @Override
    public Field createField(int height, int width, int margin, int ground, Score score) {
        return new SimpleGfxField(height, width, margin, ground, score);
    }
}
