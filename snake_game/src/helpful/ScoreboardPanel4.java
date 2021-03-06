package helpful;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import javax.swing.JFrame;

public class ScoreboardPanel4 extends javax.swing.JPanel {
    Boolean mBackButtonClicked;
    JFrame f;
    // records
    HashMap<String, Integer> records;

    /** Creates new form ScoreboardPanel4 */
    public ScoreboardPanel4(JFrame f, HashMap<String, Integer> records,
            Boolean mBackButtonClicked) {
        this.mBackButtonClicked = mBackButtonClicked;
        this.f = f;
        this.records = records;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(102, 153, 0));

        jButton1.setText("Back");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        Object[][] data = getdata();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                data,
                new String[]{
                    "Name", "Score"
                }));
        
        jTable1.setEnabled(false);

        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(313, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
    }

    public void paintComponent(Graphics g) {
        Rectangle r = g.getClipBounds();
        g.setColor(Color.black);

        g.fillRect(r.x, r.y, r.width, r.height);
    }

    public void jButton1MouseClicked(MouseEvent e) {
        mBackButtonClicked = true;
    }

    public Object[][] getdata() {

        HashMap<Integer, String> h =
                new HashMap<Integer, String>();
        Set keySet = records.keySet();

        Iterator it = keySet.iterator();

        while (it.hasNext()) {
            String key = (String) it.next();
            h.put(records.get(key), key);
        }

        java.util.List<Entry<String, Integer>> list =
                new Vector<Entry<String, Integer>>(records.entrySet());
        Collections.sort(list, new Comparator<Entry<String, Integer>>() {

            public int compare(Map.Entry<String, Integer> e1,
                    Entry<String, Integer> e2) {

                Integer i1 = e1.getValue();
                Integer i2 = e2.getValue();

                if (i1 < i2) {
                    return -1;
                } else if (i1 > i2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        Object[][] data = new Object[2][list.size()];

        Iterator i = list.iterator();

        // *write to data
        for (int ii = 0; ii < data.length; ++ii) {
            Entry<String, Integer> e = (Entry<String, Integer>) i.next();
            data[ii][0] = e.getKey();
            data[ii][1] = e.getValue();
        }

        return data;

    }


    // </editor-fold>
    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration
}
