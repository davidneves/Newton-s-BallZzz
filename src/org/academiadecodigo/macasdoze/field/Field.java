package org.academiadecodigo.macasdoze.field;

/**
 * To be instantiated by the Field of the defined library.
 * <p>
 * Draws the pictures and textes of the Field.
 * <p>
 * Created by <vi.KINGS_> David Neves, Fábio Santos, Hélia Marcos and Mário Ponte on 23/05/16.
 */
public interface Field {

    /**
     * Initiates and draws the field score and timer objects.
     */
    void normalInit();

    /**
     * Initiates and draws the field score and timer objects for the secret level.
     */
    void secretInit();

    /**
     * Updates the scores.
     */
    void displayScore();

    /**
     * Updates the score for the secret level.
     */
    void displaySecretScore();

    /**
     * Draws Game Over.
     */
    void youLose();

    /**
     * Draws You Win.
     */
    void youWin();

    /**
     * Updates the timer.
     */
    void updateTimer();

    /**
     * Clears the field upon restart.
     */
    void clearNormalMode();

    /**
     * Clears the secret mode field upon restart.
     */
    void clearSecretMode();

}
