package org.academiadecodigo.macasdoze;

/**
 *
 * Generates a random number within a range.
 *
 * Created by <vi.KINGS_> David Neves, Fábio Santos, Hélia Marcos and Mario Ponte on 06/05/16.
 */
public class RandomGenerator {

    public static int getRandomNumber(int max) {
        return getRandomByRange(0, max);
    }

    public static int getRandomByRange(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
}
