package org.academiadecodigo.macasdoze.field;

import org.academiadecodigo.macasdoze.Score;
import org.academiadecodigo.macasdoze.gameobjects.GameObjectType;

/**
 * To be instantiated by the PositionFactory of the defined library.
 * <p>
 * Creates the representations of the Game Objects.
 * <p>
 * Created by vi.KINGS David Neves, Fabio Santos, Helia Marcos and Mario Ponte on 23/05/16.
 */
public interface PositionFactory {

    /**
     * Returns a representation for a given Game Object.
     *
     * @param type the type of Game Object
     * @return a Position
     */
    Position createPosition(GameObjectType type);

    /**
     * Returns a field.
     *
     * @param height
     * @param width
     * @param margin
     * @param ground
     * @param score
     * @return a Field
     */
    Field createField(int height, int width, int margin, int ground, Score score);
}
