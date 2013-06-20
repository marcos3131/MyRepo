package snakegame;

import notnecessary.ClickableButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import utils._;

class Menu extends JPanel {
    // variables
    // *submenus

    boolean backToMenu;
    // *menu commands
    java.util.LinkedList mButtonsClickedList;
    // copied
    JFrame mJFrame;
    JPanel mfcp;
    Scoreboard mScoreboard;
    GameState mGameState;
    Dimension mWindowDimension;
    // events
    ClickableButton mPlayButton;

    public Menu(JFrame j, Scoreboard sb, GameState gs,
            Dimension windowDimension) {

        super();

        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(boxLayout);

        // copy arguments
        this.mJFrame = j;
        this.mScoreboard = sb;
        this.mGameState = gs;
        this.mWindowDimension = windowDimension;
        mfcp = (JPanel) mJFrame.getContentPane();
        initComponents();
    }


    private void initComponents() {

        // *variables
        mButtonsClickedList = new java.util.LinkedList();

        // *events
        // *menu panel and add
        this.setEnabled(true);
        mPlayButton = new ClickableButton("Play Snake") {

            public void mouseClicked(MouseEvent e) {
                synchronized (mButtonsClickedList) {
                    mButtonsClickedList.add("playsnake");
                }
            }

        };

        ClickableButton showScoresButton = new ClickableButton("Show Scores") {

            public void mouseClicked(MouseEvent e) {
                synchronized (mButtonsClickedList) {
                    mButtonsClickedList.add("show scores");
                }
            }
        };

        showScoresButton.setPreferredSize(new Dimension(150, 40));
        showScoresButton.setMinimumSize(new Dimension(150, 40));
        showScoresButton.setMaximumSize(new Dimension(150, 40));
        showScoresButton.setLocation(200, 400);
        showScoresButton.setSize(200, 200);
        showScoresButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        mPlayButton.setPreferredSize(new Dimension(150, 40));
        mPlayButton.setMinimumSize(new Dimension(150, 40));
        mPlayButton.setMaximumSize(new Dimension(150, 40));
        mPlayButton.setLocation(200, 200);
        mPlayButton.setSize(200, 200);
        mPlayButton.enable();
        mPlayButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        ClickableButton changeNameButton =
                new ClickableButton("Change Name") {

                    public void mouseClicked(MouseEvent e) {
                        synchronized (mButtonsClickedList) {
                            mButtonsClickedList.add("change name");
                        }
                    }

                };
        changeNameButton.setPreferredSize(new Dimension(150, 40));
        changeNameButton.setMinimumSize(new Dimension(150, 40));
        changeNameButton.setMaximumSize(new Dimension(150, 40));
        changeNameButton.setLocation(200, 200);
        changeNameButton.setSize(200, 200);
        changeNameButton.enable();
        changeNameButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        ClickableButton exitButton =
                new ClickableButton("Exit") {

                    public void mouseClicked(MouseEvent e) {
                        synchronized (mButtonsClickedList) {
                            mButtonsClickedList.add("exit");
                        }
                    }
                };
        exitButton.setPreferredSize(new Dimension(150, 40));
        exitButton.setMinimumSize(new Dimension(150, 40));
        exitButton.setMaximumSize(new Dimension(150, 40));
        exitButton.setLocation(200, 200);
        exitButton.setSize(200, 200);
        exitButton.enable();
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(Box.createRigidArea(new Dimension(0, 25)));
        this.add(mPlayButton);
        this.add(Box.createRigidArea(new Dimension(0, 14)));
        this.add(showScoresButton);
        this.add(Box.createRigidArea(new Dimension(0, 14)));
        this.add(changeNameButton);
        this.add(Box.createRigidArea(new Dimension(0, 14)));
        this.add(exitButton);
        mJFrame.add(this);
        mfcp.setBackground(Color.black);
        mfcp.setBorder(BorderFactory.createEmptyBorder(
                75, 75, 75, 75));
    }

    public void go() {
        mGameState.menu = true;

        while (mGameState.menu == true) {
            synchronized (mButtonsClickedList) {
                // start game...
                if (mButtonsClickedList.contains("playsnake")) {
                    mButtonsClickedList.clear();
                    mGameState.menu = false;
                    mJFrame.remove(this);

                    Play play = new Play(mJFrame, mScoreboard,
                            mGameState, mWindowDimension);

                    play.go();

                    mJFrame.add(this);
                    mJFrame.repaint();
                    mJFrame.show();
                    mGameState.menu = true;
                } else if (mButtonsClickedList.contains("show scores")) {
                    mButtonsClickedList.clear();
                    mGameState.menu = false;
                    mJFrame.remove(this);

                    mScoreboard.showScoreboardWindow(mJFrame);

                    mJFrame.add(this);
                    mJFrame.repaint();
                    mJFrame.show();

                    mGameState.menu = true;
                } else if (mButtonsClickedList.contains("change name")) {
                    mButtonsClickedList.clear();
                    mGameState.menu = false;
                    mJFrame.remove(this);
                    
                    ChangeNamePanel cnp = new ChangeNamePanel((JPanel)mJFrame.getContentPane());
                    cnp.activate();

                    mJFrame.add(this);
                    mJFrame.repaint();
                    mJFrame.show();

                    mGameState.menu = true;
                } else if (mButtonsClickedList.contains("exit")) {
                    mButtonsClickedList.clear();
                    mScoreboard.writeRecords();
                    System.exit(0);
                }
                mButtonsClickedList.clear();
            }
        }
    }

    private void showChangeNamePanel(JFrame f) {
        backToMenu = false;

        JPanel p = new JPanel();

        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

        JButton backButton = new JButton("Back");
        backButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                backToMenu = true;
            }
        });

        backButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
        backButton.setAlignmentY(Component.BOTTOM_ALIGNMENT);

        // add to JPanel
        p.add(Box.createGlue());
        p.add(backButton);
        // add to JFrame
        f.add(p);
        f.show();

        // w8 for click on backButton...
        while (backToMenu == false);

        backToMenu = false;
        f.remove(p);
    }

    public void paintComponent(Graphics g) {
        Rectangle r = g.getClipBounds();

        g.fillRect(r.x, r.y, r.width, r.height);
    }
}
