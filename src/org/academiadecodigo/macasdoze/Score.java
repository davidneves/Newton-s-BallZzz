package org.academiadecodigo.macasdoze;

/**
 * Created by <vi.KING_> David Neves on 27/05/16.
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

    public void increaseScore(int points) {
        score += points;
    }

    public void increaseGreenApples() {
        greenApples++;
    }

    public void increaseRedApples() {
        redApples++;
    }

    public void increasePurpleApples() {
        purpleApples++;
    }

    public void increaseBlackApples() {
        blackApples++;
    }

    public void increaseTimer(int n) {
        timer += n;
    }

    public void decreaseTimer() {
        timer--;
    }
}
