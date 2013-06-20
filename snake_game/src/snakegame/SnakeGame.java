package snakegame;

import utils.SnakeWindowAdapter;
import java.awt.*;
import java.io.FileNotFoundException;

import javax.swing.*;

// ustawienie fraktala na tło
interface Variable {

}

class VariableWithValue implements Variable {

    Integer mValue;

    public VariableWithValue(Integer val) {
        mValue = val;
    }
}

class VariableManager {

    java.util.HashMap<String, Variable> mVariables;

    public VariableManager() {
        mVariables = new java.util.HashMap<String, Variable>();
    }

    public void setVariable(String name) {
        mVariables.put(name, null);
    }

    public void setVariable(String name, Integer val) {
        mVariables.put(name, new VariableWithValue(val));
    }

    public Variable getVaiable(String name) {
        return mVariables.get(name);
    }
}

class ScreenObjectsManager extends VariableManager {

    public ScreenObjectsManager() {
        super();
    }
}

public class SnakeGame {

    GameState mGameState;
    Scoreboard mScoreboard;
    JFrame mJFrame;
    // window
    static Dimension mWindowDimension;

    public SnakeGame() {
        // init
        // *game objects
        mWindowDimension = new Dimension(800, 600);
        // **game state
        mGameState = new GameState();
        // **scoreboard
        mScoreboard = new Scoreboard();
        mScoreboard.setFileName("scoreboard.txt");
        mScoreboard.readRecords("scoreboard.txt");
        // *JFrame
        this.mJFrame = new JFrame();
        mJFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        mJFrame.setSize(mWindowDimension);
        mJFrame.setResizable(false);
        mJFrame.setLocation(100, 100);
        mJFrame.setVisible(true);
        mJFrame.setFocusable(true);
        // *close operation
        mJFrame.addWindowListener(
                new SnakeWindowAdapter(mScoreboard));
        // *set buffer
        //mJFrame.createBufferStrategy(2);
    }

    public void go() {
        Menu menu = new Menu(mJFrame, mScoreboard, mGameState,
                mWindowDimension);

        menu.go();
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.

        Runnable r = new Runnable() {

                    public void run() {
                        SnakeGame sg = new SnakeGame();

                        sg.go();
                    }
       };
       r.run();
    }
}