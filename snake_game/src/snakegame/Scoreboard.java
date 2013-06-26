package snakegame;

import utils._;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Scoreboard {
    // file name

    String mFName;
    // back button
    _<Boolean> backToMenu;
    // records
    HashMap<String, Integer> records;

    public Scoreboard() {
        records = new HashMap<String, Integer>();
        backToMenu = new _<Boolean>(false);
    }

    public void addRecord(String name, int points) {
        Integer val;
        val = records.get(name);

        if (val == null) {
            records.put(name, points);
        } else {
            if (points > val) {
                records.put(name, points);
            }
        }

    }

    public void resetRecords() {
        records.clear();
    }

    public void setFileName(String fn) {
        mFName = fn;
    }

    public void writeRecords() {
        try {
            FileOutputStream fos =
                    new FileOutputStream(mFName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(records);
            oos.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void writeRecords(String fname) {
        try {
            FileOutputStream fos =
                    new FileOutputStream(fname);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(records);
            oos.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void readRecords(String fname) {
        HashMap<String, Integer> records = null;

        try {
            FileInputStream fis =
                    new FileInputStream(fname);
            ObjectInputStream ois = new ObjectInputStream(fis);

            records = (HashMap<String, Integer>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            System.err.println(e);
        }

        if (records == null) {
            return;
        }

        this.records = records;
    }

    @Override
    public String toString() {
        String s = "";

        if (records == null) {
            return s;
        }

        Iterator i = records.entrySet().iterator();

        while (i.hasNext()) {
            Map.Entry<String, Integer> e = (Map.Entry<String, Integer>) i.next();
            s += e.getKey() + " " + e.getValue() + '\n';
        }

        return s;
    }

    public void printOnScreen(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.BOLD, 16));
        int charSize = (int) g.getFontMetrics().getHeight();


        Iterator i = records.entrySet().iterator();

        for (int ii = 0; ii < 20 && i.hasNext(); ++ii) {
            Map.Entry<String, Integer> e = (Map.Entry<String, Integer>) i.next();
            g.drawString(e.getKey() + " " + e.getValue(), 200, 200 + ii * charSize);
        }
    }

    @SuppressWarnings("empty-statement")
    public void showScoreboardWindow(JFrame f) {
        ScoreboardPanel sp = new ScoreboardPanel((JPanel)f.getContentPane(), records, backToMenu);

        f.show();

        // w8 for click on backButton...
        while (backToMenu.g() == false)
            ;
        
        f.remove(sp);
        f.repaint();
        f.show();
    }

    public static void main(String[] args) {
        Scoreboard sb = new Scoreboard();

        sb.addRecord("Jaś", 3);
        sb.addRecord("Małgosia", 10);
        sb.addRecord("Marek", 29);
        sb.addRecord("Jaś", 15);

        sb.writeRecords("scoreboard.txt");
        sb.resetRecords();
        sb.readRecords("scoreboard.txt");

        System.out.println(sb);
    }
}
