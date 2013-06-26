package snakegame;

import utils.SnakeWindowAdapter;
import utils._;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;



/*
 * Bugi:
 * *wykrywa kolizję, jak się czasami naciśnie przyciski za szybko
 */
class Play extends JPanel implements KeyListener {

    // constants
    final Point VectorZero = new Point(0, 0);
    // variables
    // *window
    Dimension mWindowDimension;
    // *game
    JFrame mJFrame;
    Scoreboard mScoreboard;
    GameState mGameState;
    // utils
    Random generator = new Random();
    // player
    _<String> mPlayerName;
    // game
    // *objects on map
    // **snake
    Point mStartPoint;
    LinkedList<Point> snake;
    Point derivativeVector;
    // **food
    Point food;
    // *points
    int points;

    public Play(JFrame j, Scoreboard sb, GameState gs,
            Dimension windowDimension, _<String> pname) {
        // init
        // *variables
        this.mJFrame = j;
        this.mScoreboard = sb;
        this.mGameState = gs;
        this.mWindowDimension = windowDimension;

        // *set buffer
        //mJFrame.createBufferStrategy(2);

        // *add keyListener
        mJFrame.addKeyListener(this);

        // *add play panel
        //mJFrame.add(this);

        // player
        mPlayerName = pname;

        // game
        snake = new LinkedList<Point>();
        mStartPoint = new Point(20, 20);
        derivativeVector = new Point(0, 0);
        food = new Point(20, 20);
    }

    public void go() {
        // init window
        //mJFrame.add(this);
        // inti game
        initGame();

        // game loop
        while (mGameState.playing) {
            long start = System.currentTimeMillis();
            gameLoop();
            while (System.currentTimeMillis() - start < 40) {
                // repainting after every 40 s.
            }
        }
        endGame();
        exitPlay();
    }

    void exitPlay() {
        mJFrame.removeKeyListener(this);
        mJFrame.getBufferStrategy().dispose();
    }

    private void initGame() {
        mGameState.playing = true;
        mGameState.scoreboard = true;

        // init snake
        mStartPoint.x = generator.nextInt((mWindowDimension.width / 10) - 4) + 2;
        mStartPoint.y = generator.nextInt((mWindowDimension.height / 10) - 5) + 3;
        snake.clear();
        growSnake(6);
        derivativeVector = new Point(0, 0);

        // add food
        food = new Point(10, 10);

        // reset score
        points = 0;
    }

    void endGame() {
        mScoreboard.addRecord(mPlayerName.g(), points);
    }

    private void gameLoop() {
        // game logic

        // arrow button pressed...
        if (!derivativeVector.equals(VectorZero)) {
            // *move the snake
            moveSnake(derivativeVector);

            // *check if snake has eaten food
            if (snake.getFirst().equals(food)) {
                moveFood();
                growSnake(3);
                points++;
            }

            // *check if any walls have been hit
            if (snake.getFirst().x <= 0
                    || snake.getFirst().x
                    >= mWindowDimension.width / 10 - 1
                    || snake.getFirst().y <= 2
                    || snake.getFirst().y
                    >= mWindowDimension.height / 10 - 1) {
                endGame();
                initGame();
            }

            // *check if the snake has hit itself
            for (int n = 1; n < snake.size(); n++) {
                if (snake.getFirst().equals(snake.get(n))) {
                    endGame();
                    initGame();
                }
            }
        }

        // draw all
        drawFrame();
    }

    private void drawFrame() {
        // draw all
        BufferStrategy bf = mJFrame.getBufferStrategy();
        Graphics g = null;

        try {
            g = bf.getDrawGraphics();

            // clear the back buffer
            g.setColor(Color.black);
            g.fillRect(0, 0, mWindowDimension.width,
                    mWindowDimension.height);
            g.setColor(Color.GREEN);
            g.fillRect(10, 30, mWindowDimension.width
                    - mWindowDimension.width % 10 - 20,
                    mWindowDimension.height
                    - mWindowDimension.height % 10 - 40);

            drawSnake(g);
            drawFood(g);
            drawPoints(g);
            if (mGameState.scoreboard) {
                mScoreboard.printOnScreen(g);
            }
        } finally {
            // dispose graphic if done
            g.dispose();
        }

        // Shows the contents of the backbuffer on the screen.
        bf.show();

        //Tell the System to do the Drawing now, otherwise it can take a few extra ms until
        //Drawing is done which looks very jerky
        Toolkit.getDefaultToolkit().sync();
    }

    private void drawSnake(Graphics g) {
        for (int n = 0; n < snake.size(); n++) {
            g.setColor(new Color(808000));
            Point p = snake.get(n);
            g.fillOval(p.x * 10, p.y * 10, 10, 10);
        }
    }

    private void moveSnake(Point d) {
        for (int n = snake.size() - 1; n >= 1; n--) {
            snake.get(n).setLocation(snake.get(n - 1));
        }
        snake.getFirst().x += d.x;
        snake.getFirst().y += d.y;
    }

    private void growSnake(int n) {
        while (n > 0) {
            if (snake.isEmpty()) {
                snake.add(mStartPoint);
            } else {
                snake.add(new Point(snake.getLast()));
            }
            n--;
        }
    }

    private void moveFood() {
        food.x = generator.nextInt((mWindowDimension.width / 10) - 4) + 2;
        food.y = generator.nextInt((mWindowDimension.height / 10) - 5) + 3;
    }

    private void drawFood(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(food.x * 10, food.y * 10, 10, 10);
    }

    private void drawPoints(Graphics g) {
        g.setColor(Color.GRAY);
        g.drawString("points: " + points, 10, 40);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            if (Math.abs(derivativeVector.x) != 1) {
                derivativeVector.x = -1;
                derivativeVector.y = 0;
            }
        } else if (key == KeyEvent.VK_UP) {
            if (Math.abs(derivativeVector.y) != 1) {
                derivativeVector.x = 0;
                derivativeVector.y = -1;
            }
        } else if (key == KeyEvent.VK_RIGHT) {
            if (Math.abs(derivativeVector.x) != 1) {
                derivativeVector.x = 1;
                derivativeVector.y = 0;
            }
        } else if (key == KeyEvent.VK_DOWN) {
            if (Math.abs(derivativeVector.y) != 1) {
                derivativeVector.x = 0;
                derivativeVector.y = 1;
            }
        } else if (key == KeyEvent.VK_ESCAPE) {
            mGameState.playing = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // not needed
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // not needed
    }

    public static void main(String[] args) {
        JFrame lJFrame = new JFrame();
        // init
        // *game objects
        Dimension lWindowDimension = new Dimension(800, 600);
        // **game state
        GameState lGameState = new GameState();
        // **scoreboard
        Scoreboard lScoreboard = new Scoreboard();
        lScoreboard.readRecords("scoreboard.txt");
        // *JFrame
        lJFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        lJFrame.setSize(lWindowDimension);
        lJFrame.setResizable(false);
        lJFrame.setLocation(100, 100);
        lJFrame.setVisible(true);
        // *close operation
        lJFrame.addWindowListener(
                new SnakeWindowAdapter(lScoreboard));
        
        _<String> pname = new _<String>("Unnamed");
        
        Play f = new Play(lJFrame, new Scoreboard(),
                new GameState(), lWindowDimension, pname);

        f.go();
    }
}
