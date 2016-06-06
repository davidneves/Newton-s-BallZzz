package org.academiadecodigo.macasdoze;

/**
 * To be instantiated by the MacasDoZe class.
 * <p>
 * Counts the number of Apples collected and increases the score.
 * <p>
 * Created by vi.KINGS David Neves, Fabio Santos, Helia Marcos and Mario Ponte on 23/05/16.
 */
public class Score {

    private int score;
    private int timer;

    private int greenApples;
    private int redApples;
    private int purpleApples;
    private int blackApples;


    public Score(int timer) {
        this.timer = timer;
    }

    public int getScore() {
        return score;
    }

    public int getBlackApples() {
        return blackApples;
    }

    public int getPurpleApples() {
        return purpleApples;
    }

    public int getRedApples() {
        return redApples;
    }

    public int getGreenApples() {
        return greenApples;
    }

    public int getTimer() {
        return timer;
    }

    /**
     * @param points Number of points by which the score will be increased.
     */
    public void increaseScore(int points) {
        score += points;
    }

    /**
     * Increases the Green Apples.
     */
    public void increaseGreenApples() {
        greenApples++;
    }

    /**
     * Increases the Red Apples.
     */
    public void increaseRedApples() {
        redApples++;
    }

    /**
     * Increases the Purple Apples.
     */
    public void increasePurpleApples() {
        purpleApples++;
    }

    /**
     * Increases the Black Apples.
     */
    public void increaseBlackApples() {
        blackApples++;
    }

    /**
     * @param n Number by which the timer will be increased.
     */
    public void increaseTimer(int n) {
        timer += n;
    }

    /**
     * Decreases the timer.
     */
    public void decreaseTimer() {
        timer--;
    }
}
