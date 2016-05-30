package org.academiadecodigo.macasdoze;

/**
 * Created by <vi.KING_> David Neves on 27/05/16.
 */
public class Score {

    public static int score;
    public static int rottenApples;

    public static int timer = 30;

    public static int greenApples;
    public static int redApples;
    public static int purpleApples;
    public static int blackApples;

    public static void increaseScore(int points) {
        score += points;
    }

    public static void increaseRottenApples() {
        rottenApples++;
    }

    public static void increaseGreenApples() {
        greenApples++;
    }

    public static void increaseRedApples() {
        redApples++;
    }

    public static void increasePurpleApples() {
        purpleApples++;
    }

    public static void increaseBlackApples() {
        blackApples++;
    }

    public static void increaseTimer(int n) {
        timer += n;
    }

}
