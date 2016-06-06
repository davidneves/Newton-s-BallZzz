package org.academiadecodigo.macasdoze.field;

/**
 * To be instantiated by the Position of the defined library.
 * <p>
 * Creates the position of the object.
 * <p>
 * Created by vi.KINGS David Neves, Fabio Santos, Helia Marcos and Mario Ponte on 23/05/16.
 */
public interface Position {

    int getX();

    int getY();

    int getWidth();

    int getHeight();

    /**
     * Deletes the representation of the object.
     */
    void deleteObject();

    /**
     * Updates the image of the object with a given path.
     * @param path
     */
    void updatePicture(String path);
}
