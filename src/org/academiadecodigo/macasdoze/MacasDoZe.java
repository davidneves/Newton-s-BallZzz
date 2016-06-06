package org.academiadecodigo.macasdoze;

import org.academiadecodigo.macasdoze.field.Field;
import org.academiadecodigo.macasdoze.gameobjects.Apple;
import org.academiadecodigo.macasdoze.gameobjects.GameObjectsFactory;
import org.academiadecodigo.macasdoze.gameobjects.Newton;
import org.academiadecodigo.macasdoze.simplegfx.SimpleGfxMenu;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * To be instantiated by the Main.
 * <p>
 * The game logic.
 * <p>
 * Created by vi.KINGS David Neves, Fabio Santos, Helia Marcos and Mario Ponte on 23/05/16.
 */
public class MacasDoZe implements KeyboardHandler {

    public static final int HEIGHT = 900;
    public static final int WIDTH = 600;
    public static final int MARGIN = 10;
    public static final int GROUND = 50;
    public static int delay;

    private Field field;
    private GameObjectsFactory factory;
    private LinkedList<Apple> appleList;
    private AppleCollector appleCollector;
    private Newton newton;
    private SimpleGfxMenu menu;
    private Score score;
    private boolean pause;
    private boolean restart;


    public MacasDoZe(GameObjectsFactory factory, int delay) {
        this.factory = factory;
        this.delay = delay;
    }

    /**
     * Initializes the Menu and its background sound.
     * <p>
     *
     * @throws InterruptedException
     */
    public void init() throws InterruptedException {
        menu = new SimpleGfxMenu();

        menu.init();
        SoundHandler.playMenuSound();

        while (!menu.continueGame()) {
            menu.animateMenu();
        }

        SoundHandler.stopSound("/resources/Mozart.wav");
        menu.clearMenu();
        gameDraw(menu.isNormalMode());
        start(menu.isNormalMode());
    }

    /**
     * Draws the game
     *
     * @param normalMode
     */
    private void gameDraw(boolean normalMode) {


        score = new Score(30);
        field = factory.getPositionFactory().createField(HEIGHT, WIDTH, MARGIN, GROUND, score);
        if (normalMode) {
            SoundHandler.playSound();
            field.normalInit();
        } else {
            field.secretInit();
            SoundHandler.playSecretSong();
        }

        newton = factory.createNewton();

        appleList = new LinkedList();
        appleCollector = new AppleCollector(newton, appleList, score);

        setKeyboard();

    }

    /**
     * Initializes the game
     * <p>
     *
     * @param normalMode
     * @throws InterruptedException
     */
    private void start(boolean normalMode) throws InterruptedException {

        int cycles = 0;

        while (checkGameEnd()) {

            while (pause) {
                Text gameName = new Text(300, 150, "Paused");
                gameName.setColor(Color.WHITE);
                gameName.grow(200, 60);
                gameName.draw();
                Thread.sleep(160);
                gameName.delete();
                Thread.sleep(80);
            }

            if (cycles % 80 == 0) {
                field.updateTimer();
            }

            cycles++;

            Thread.sleep(delay);

            if (normalMode) {
                createApple(100);
            } else {
                createNuggets(100);
            }

            moveApples();
            newton.move();
            appleCollector.appleCatch();

            if (normalMode) {
                field.displayScore();
            } else {
                field.displaySecretScore();
            }

            checkGameEnd();
        }
    }

    /**
     * @param prob Probability of creating Apples.
     */
    private void createApple(int prob) {

        if (RandomGenerator.getRandomNumber(prob) == 1) {

            appleList.add(factory.createApple());
        }
    }

    /**
     * @param prob Probability of creating Nuggets.
     */
    private void createNuggets(int prob) {

        if (RandomGenerator.getRandomNumber(prob) == 1) {

            appleList.add(factory.createNugget());
        }

    }

    /**
     * @param prob Probability of creating Black Apples.
     */
    private void createBlackApple(int prob) {

        if (RandomGenerator.getRandomNumber(prob) == 1) {

            appleList.add(factory.createBlackApple());
        }
    }

    /**
     * Makes the Apples fall.
     */
    private void moveApples() {

        Iterator<Apple> it = appleList.iterator();

        while (it.hasNext()) {

            Apple apple = it.next();

            if (!apple.isFallen()) {
                apple.fall();
            }

            if (apple.getPosition().getY() > HEIGHT - GROUND) {
                apple.setFallen(true);
                apple.increaseFallenCycleCounter();

                if (apple.getFallenCycleCounter() % 240 == 0) { //3" rule
                    apple.getPosition().deleteObject();
                    it.remove();
                }
            }
        }
    }


    /**
     * Checks if the game has ended.
     * <p>
     *
     * @return boolean
     * @throws InterruptedException
     */
    private boolean checkGameEnd() throws InterruptedException {

        if (score.getTimer() == 0) {

            if (!menu.isNormalMode()) {
                field.youWin();
                newton.getPosition().updatePicture("resources/newtonWinLeft69x115.png");
                newton.setWinner(true);
                endSecret();

            } else if (score.getScore() < 250) {
                field.youLose();
                newton.getPosition().updatePicture("resources/newtonDL.png");
                newton.setAlive(false);
                endLose();

            } else {
                field.youWin();
                newton.getPosition().updatePicture("resources/newtonWinLeft69x115.png");
                newton.setWinner(true);
                endWin();
            }
            return false;
        }
        return true;
    }

    /**
     * If the player wins it ends the game and plays the victory sound.
     * <p>
     *
     * @throws InterruptedException
     */
    private void endWin() throws InterruptedException {

        SoundHandler.stopSound("/resources/tetris.wav");
        SoundHandler.playVictory();

        while (true) {

            Thread.sleep(delay);

            createApple(6);
            newton.move();
            moveApples();

            if (restart) {
                clear();
                SoundHandler.stopSound("/resources/Celebration.wav");
                Main.main(new String[]{});
            }
        }
    }

    /**
     * If the player loses it ends the game and plays the game over sound.
     * <p>
     *
     * @throws InterruptedException
     */
    private void endLose() throws InterruptedException {

        SoundHandler.stopSound("/resources/tetris.wav");
        SoundHandler.playGameOver();

        while (true) {

            Thread.sleep(delay);

            createBlackApple(50);
            newton.move();
            moveApples();

            if (restart) {
                clear();
                SoundHandler.stopSound("/resources/gameover.wav");
                Main.main(new String[]{});
            }
        }
    }

    /**
     * It ends the game's secret level and plays the victory sound.
     * <p>
     *
     * @throws InterruptedException
     */
    private void endSecret() throws InterruptedException {

        SoundHandler.stopSound("/resources/bonusLevelSong.wav");
        SoundHandler.playVictory();

        while (true) {

            Thread.sleep(delay);

            createNuggets(10);
            moveApples();
            newton.move();

            if (restart) {
                clear();
                SoundHandler.stopSound("/resources/Celebration.wav");
                Main.main(new String[]{});
            }
        }

    }

    /**
     * Sets the events of the keys P and R of the Keyboard.
     */
    private void setKeyboard() {

        Keyboard k = new Keyboard(this);

        KeyboardEvent pPressedEvent = new KeyboardEvent();
        pPressedEvent.setKey(KeyboardEvent.KEY_P);
        pPressedEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(pPressedEvent);

        KeyboardEvent rPressedEvent = new KeyboardEvent();
        rPressedEvent.setKey(KeyboardEvent.KEY_R);
        rPressedEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(rPressedEvent);

    }

    /**
     * Clears the field for the two levels of the game and stops the sound.
     */
    private void clear() {

        if (menu.isNormalMode()) {
            field.clearNormalMode();
        } else {
            field.clearSecretMode();
        }
        field = null;
        factory = null;
        appleList = null;
        appleCollector = null;
        newton = null;
        menu = null;
        restart = false;

    }

    /**
     * @param keyboardEvent
     * @see KeyboardHandler#keyPressed(KeyboardEvent)
     */
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_P) {

            if (!pause) {
                pause = true;

            } else {
                pause = false;
            }
        } else if (keyboardEvent.getKey() == KeyboardEvent.KEY_R) {
            restart = true;
        }
    }

    /**
     * @param keyboardEvent
     * @see KeyboardHandler#keyReleased(KeyboardEvent)
     */
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
