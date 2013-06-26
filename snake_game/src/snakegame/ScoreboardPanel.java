package snakegame;

import utils._;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class ScoreboardPanel extends javax.swing.JPanel {
    _<Boolean> mBackButtonClicked;
    JPanel fcp;
    // records
    HashMap<String, Integer> records;

    /** Creates new form ScoreboardPanel4 */
    public ScoreboardPanel(JPanel p, HashMap<String, Integer> records,
            _<Boolean> mBackButtonClicked) {
        this.mBackButtonClicked = mBackButtonClicked;
        this.mBackButtonClicked.s(Boolean.FALSE);
        this.fcp = p;
        this.records = records;
        initComponents();
        fcp.add(this);
    }
    
    private void initComponents() {
        jPanel1 = new JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        fcp.setBackground(Color.black);
        this.setBackground(Color.green);
        
        String colnames[] = { "Name", "Score" };
        Object[][] data = getdata();
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                data,
                colnames));
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.CENTER);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
        jTable1.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
        jTable1.setGridColor(Color.red);
        JTableHeader header = jTable1.getTableHeader();
        header.setBackground(Color.yellow);
        // jTable1.setEnabled(false);
        jTable1.setShowVerticalLines(false);
        jTable1.setBackground(Color.gray);

        jScrollPane1.setViewportView(jTable1);
        jScrollPane1.setBackground(Color.gray);

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
        this.add(jScrollPane1, BorderLayout.CENTER);
        this.add(jPanel1, BorderLayout.SOUTH);
        
        //this.setPreferredSize(new Dimension(psizex,psizey));
        this.layout();
        fcp.setLayout(new BorderLayout());
        fcp.setBorder(BorderFactory.createEmptyBorder(
                75, 75, 75, 75));
    }// </editor-fold>

    public void jButton1MouseClicked(MouseEvent e) {
        mBackButtonClicked.s(true);
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

        Object[][] data = new Object[list.size()][2];

        Iterator i = list.iterator();

        // *write to data
        for (int ii = data.length-1; ii >= 0; --ii) {
            Entry<String, Integer> e = (Entry<String, Integer>) i.next();
            data[ii][0] = e.getKey();
            data[ii][1] = e.getValue();
        }

        return data;
    }

    // Variables declaration - do not modify
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration

}
