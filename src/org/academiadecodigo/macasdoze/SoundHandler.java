package org.academiadecodigo.macasdoze;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Sounds that our game will implement.
 * <p>
 * <p>
 * Created by vi.KINGS David Neves, Fabio Santos, Helia Marcos and Mario Ponte on 23/05/16.
 */
public class SoundHandler {


    private static Map<String, Clip> soundMap = new HashMap();


    public static void loadSound(String pathStr) {


        // to load from jar
        URL soundURL = SoundHandler.class.getResource(pathStr);

        AudioInputStream inputStream = null;
        Clip clip = null;

        try {

            if (soundURL == null) {
                pathStr = pathStr.substring(1);
                File file = new File(pathStr);
                soundURL = file.toURI().toURL();
            }

            inputStream = AudioSystem.getAudioInputStream(soundURL);

            clip = AudioSystem.getClip();
            clip.open(inputStream);

            soundMap.put(pathStr, clip);

            clip.start();

        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }


    /**
     * Stops the music.
     */
    public static void stopSound(String pathStr) {

        URL soundURL = SoundHandler.class.getResource(pathStr);

        if (soundURL == null) {
            pathStr = pathStr.substring(1);
        }

        Clip clip = soundMap.get(pathStr);

        clip.close();
        soundMap.remove(pathStr);
    }



    /**
     * Loads and plays the menu music.
     */
    public static void playMenuSound() {

        loadSound("/resources/Mozart.wav");
    }

    /**
     * Loads and plays the normal game music.
     */
    public static void playSound() {

        loadSound("/resources/tetris.wav");
    }


    /**
     * Plays a sound every time you catch one apple.
     */
    public static void appleCatchSound() {

        loadSound("/resources/Coin.wav");
    }

    /**
     * Plays a sound every time Newton jumps.
     */
    public static void jumpSound() {

        loadSound("/resources/jump.wav");
    }

    /**
     * Plays a music when you lose the game.
     */
    public static void playGameOver() {
        System.out.println("gameover");

        loadSound("/resources/gameover.wav");
    }

    /**
     * Plays a music when you win the game.
     */
    public static void playVictory() {

        loadSound("/resources/Celebration.wav");
    }

    /**
     * Plays the secret level music.
     */
    public static void playSecretSong() {

        loadSound("/resources/bonusLevelSong.wav");
    }
}
