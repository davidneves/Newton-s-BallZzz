package org.academiadecodigo.macasdoze;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Sounds that our game will implement
 * <p>
 * <p>
 * <p>
 * Created by <vi.KINGS_> David Neves, Fábio Santos, Hélia Marcos and Mário Ponte on 23/05/16.
 */
public class Sound {

    private static InputStream in;
    private static AudioStream as;

    /**
     * Loads and plays the menu music.
     */
    public static void playMenuSound() {

        try {

            in = new FileInputStream("resources/Mozart.wav");
            as = new AudioStream(in);

            AudioPlayer.player.start(as);

        } catch (Exception e) {
            System.out.println("file not found.");
        }
    }

    /**
     * Loads and plays the normal game music.
     */
    public static void playSound() {

        try {

            in = new FileInputStream("resources/tetris.wav");
            as = new AudioStream(in);

            AudioPlayer.player.start(as);

        } catch (Exception e) {
            System.out.println("file not found.");
        }
    }

    /**
     * Stops the music.
     */
    public static void stopSound() {

        AudioPlayer.player.stop(as);

    }

    /**
     * Plays a sound every time you catch one apple.
     */
    public static void appleCatchSound() {

        try {

            InputStream in = new FileInputStream("resources/Coin.wav");
            AudioStream as = new AudioStream(in);

            AudioPlayer.player.start(as);

        } catch (Exception e) {
            System.out.println("file not found.");
        }

    }

    /**
     * Plays a sound every time Newton jumps.
     */
    public static void jumpSound() {

        try {

            InputStream in = new FileInputStream("resources/jump.wav");
            AudioStream as = new AudioStream(in);

            AudioPlayer.player.start(as);

        } catch (Exception e) {
            System.out.println("file not found.");
        }

    }

    /**
     * Plays a music when you lose the game.
     */
    public static void playGameOver() {

        try {

            in = new FileInputStream("resources/gameover.wav");
            as = new AudioStream(in);

            AudioPlayer.player.start(as);

        } catch (Exception e) {
            System.out.println("file not found.");
        }
    }

    /**
     * Plays a music when you win the game.
     */
    public static void playVictory() {

        try {

            in = new FileInputStream("resources/Celebration.wav");
            as = new AudioStream(in);

            AudioPlayer.player.start(as);

        } catch (Exception e) {
            System.out.println("file not found.");
        }
    }

    /**
     * Plays the secret level music.
     */
    public static void playSecretSong() {

        try {

            in = new FileInputStream("resources/bonusLevelSong.wav");
            as = new AudioStream(in);

            AudioPlayer.player.start(as);

        } catch (Exception e) {
            System.out.println("file not found.");
        }
    }


}
