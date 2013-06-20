package com.mycompany.gravity;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        JFrame jf = new JFrame ();
        jf.setVisible(true);
        jf.setSize(new Dimension(500,500));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel jp = new JPanel();
    }
}
