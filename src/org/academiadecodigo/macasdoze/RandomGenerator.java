
package org.academiadecodigo.macasdoze;
/**
 * Created by <vi.KING_> David Neves on 06/05/16.
 */
public class RandomGenerator {

    public static int getRandomNumber(int max) {
        return getRandomByRange(0, max);
    }

    public static int getRandomByRange(int min, int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }
}
