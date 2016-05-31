package org.academiadecodigo.macasdoze;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by <vi.KING_> David Neves on 29/05/2016.
 */
public class Sound {

    private static InputStream in;
    private static AudioStream as;

    public static void playMenuSound() {

        try {

            in = new FileInputStream("resources/Mozart.wav");
            as = new AudioStream(in);

            AudioPlayer.player.start(as);

        } catch (Exception e) {
            System.out.println("file not found.");
        }
    }

    public static void playSound() {

        try {

            in = new FileInputStream("resources/tetris.wav");
            as = new AudioStream(in);

            AudioPlayer.player.start(as);

        } catch (Exception e) {
            System.out.println("file not found.");
        }
    }

    public static void stopSound() {

        AudioPlayer.player.stop(as);

    }

    public static void appleCatchSound() {

        try {

            InputStream in = new FileInputStream("resources/Coin.wav");
            AudioStream as = new AudioStream(in);

            AudioPlayer.player.start(as);

        } catch (Exception e) {
            System.out.println("file not found.");
        }

    }

    public static void playGameOver() {

        try {

            in = new FileInputStream("resources/gameover.wav");
            as = new AudioStream(in);

            AudioPlayer.player.start(as);

        } catch (Exception e) {
            System.out.println("file not found.");
        }
    }

    public static void playVictory() {

        try {

            in = new FileInputStream("resources/chorus.wav");
            as = new AudioStream(in);

            AudioPlayer.player.start(as);

        } catch (Exception e) {
            System.out.println("file not found.");
        }
    }



}
