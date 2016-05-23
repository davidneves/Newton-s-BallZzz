package org.academiadecodigo.macasdoze.field;

import org.academiadecodigo.macasdoze.gameobjects.AppleType;

/**
 * Created by <vi.KING_> David Neves on 23/05/16.
 */
public interface PositionFactory {

    Position createPosition(AppleType type);
}
