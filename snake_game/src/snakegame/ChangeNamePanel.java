package snakegame;

import java.awt.Color;
import utils._;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChangeNamePanel extends javax.swing.JPanel {
    _<Boolean> mBackButtonClicked;
    JPanel fcp;

    /** Creates new form ScoreboardPanel4 */
    public ChangeNamePanel(JPanel p) {
        mBackButtonClicked = new _<Boolean>(false);
        this.fcp = p;
        initComponents();
    }

    private void initComponents() {
        jPanel1 = new JPanel();
        jButton1 = new javax.swing.JButton();

        fcp.setLayout(new flowlayout());
        fcp.add(new JLabel("asdf"));
        fcp.setBackground(Color.red);

        /*
        jButton1.setText("Back");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jPanel1.setLayout(new BorderLayout());
        jPanel1.add(new JPanel(), BorderLayout.CENTER);
        jPanel1.add(jButton1, BorderLayout.EAST);
        jPanel1.setBackground(this.getBackground());

        this.setLayout(new BorderLayout());
        this.add(new JPanel(), BorderLayout.CENTER);
        this.add(jPanel1, BorderLayout.SOUTH);

        //this.setPreferredSize(new Dimension(psizex,psizey));
        this.layout();
        fcp.setLayout(new BorderLayout());
        fcp.setBorder(BorderFactory.createEmptyBorder(
                75, 75, 75, 75));
        fcp.add(this);

        /*
        jPanel1 = new JPanel();
        jButton1 = new javax.swing.JButton();

        fcp.setBackground(Color.black);
        this.setBackground(Color.green);

        jButton1.setText("Back");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jPanel1.setLayout(new BorderLayout());
        jPanel1.add(new JPanel(), BorderLayout.CENTER);
        jPanel1.add(jButton1, BorderLayout.EAST);
        jPanel1.setBackground(this.getBackground());

        this.setLayout(new BorderLayout());
        this.add(jPanel1, BorderLayout.SOUTH);

        //this.setPreferredSize(new Dimension(psizex,psizey));
        this.layout();
        fcp.setLayout(new BorderLayout());
        fcp.setBorder(BorderFactory.createEmptyBorder(
                75, 75, 75, 75));
        fcp.add(this, BorderLayout.CENTER);
         * 
         */
    }// </editor-fold>

    public void jButton1MouseClicked(MouseEvent e) {
        mBackButtonClicked.s(true);
    }

    // Variables declaration - do not modify
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jButton1;
    // End of variables declaration

    @SuppressWarnings("empty-statement")
    public void activate() {
        fcp.show(); // not needed
        fcp.repaint();

        // w8 for click on backButton...
        while (mBackButtonClicked.g() == false)
            ;
        fcp.remove(this);
        fcp.repaint();
        //fcp.show();
    }

}
