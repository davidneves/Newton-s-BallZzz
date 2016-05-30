package org.academiadecodigo.macasdoze.simplegfx;

import org.academiadecodigo.simplegraphics.pictures.Picture;


/**
 * Created by <vi.KING_> David Neves on 24/05/2016.
 */
public class SimpleGfxNewton extends SimpleGfxMovablePosition {


    public static final int WIDTH = 69;
    public static final int HEIGHT = 117;


    public SimpleGfxNewton(int x, int y) {
        super(new Picture(x, y, "resources/newtonL.png"));

    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

<<<<<<< HEAD
    public SimpleGfxNewton(int x, int y) {
        super(new Picture(x, y,"resources/newtonWL.png"));

    }

=======
>>>>>>> 0737c0ee45536cd7b0acd0914c5a1124b744f39f
}
