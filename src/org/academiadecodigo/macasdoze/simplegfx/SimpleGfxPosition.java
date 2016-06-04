package org.academiadecodigo.macasdoze.simplegfx;

import org.academiadecodigo.macasdoze.field.Position;
import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Defines the positon of one object using the SimpleGraphics library and draws it
 * <p>
 * <p>
 * Created by <vi.KINGS_> David Neves, Fábio Santos, Hélia Marcos and Mário Ponte on 23/05/16.
 */
public abstract class SimpleGfxPosition implements Position {

    private Shape shape;

    /**
     * Creates a shape and draws it
     * @param shape
     */
    public SimpleGfxPosition(Shape shape) {
        this.shape = shape;
        shape.draw();
    }


    public Shape getShape() {
        return shape;
    }

    /**
     *
     * @see Position#updatePicture(String)
     */
    public void updatePicture(String path) {

        try {
        ((Picture) shape).load(path);
        } catch (Exception e) {
            System.out.println("newton moving error");
        }

    }


    @Override
    public int getX() {
        return shape.getX();
    }

    @Override
    public int getY() {
        return shape.getY();
    }

    /**
     * @see Position#deleteObject()
     */
    @Override
    public void deleteObject() {
        shape.delete();
    }
}
