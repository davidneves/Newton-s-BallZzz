package org.academiadecodigo.macasdoze.field;

import org.academiadecodigo.macasdoze.gameobjects.GameObjectType;

/**
 * Created by <vi.KING_> David Neves on 23/05/16.
 */
public interface PositionFactory {

    Position createPosition(GameObjectType type);

    Field createField(int height, int width, int margin);
}
