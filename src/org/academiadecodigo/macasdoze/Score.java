package org.academiadecodigo.macasdoze;

/**
 * Created by <vi.KING_> David Neves on 27/05/16.
 */
public class Score {

    public static int score;

    public static int greenApples;
    public static int redApples;
    public static int megaApples;

    public static void increaseScore(int points) {
        score += points;
    }

    public static void increaseGreenApples() {
        Score.greenApples++;
    }

    public static void increaseRedApples() {
        Score.redApples++;
    }

    public static void increaseMegaApples() {
        Score.megaApples++;
    }
}
