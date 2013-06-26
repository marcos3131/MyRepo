package snakegame;

import utils._;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class ChangeNamePanel1 extends JPanel {
    _<Boolean> mBackButtonClicked;
    JPanel fcp;

    /** Creates new form ScoreboardPanel4 */
    public ChangeNamePanel1(JPanel p) {
        mBackButtonClicked = new _<Boolean>(false);
        this.fcp = p;
        initComponents();
        fcp.repaint();
    }

    private void initComponents() {
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
