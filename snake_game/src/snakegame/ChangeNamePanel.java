package snakegame;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import utils._;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangeNamePanel extends JPanel {
	
	JPanel fcp;
    _<Boolean> mBackButtonClicked;
    _<String> mPlayerName;
    private JTextField txtTypeNameHere;

	/**
	 * Create the panel.
	 */
	public ChangeNamePanel(JPanel _fcp, _<String> pname) {
		fcp = _fcp;
		mPlayerName = pname;
		mBackButtonClicked = new _<Boolean>(false);
		mBackButtonClicked.s(false);
		
		fcp.add(this, BorderLayout.CENTER);
		this.setAlignmentX(CENTER_ALIGNMENT);
		this.setAlignmentY(CENTER_ALIGNMENT);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(195, 136, 56, 17);
		add(lblNewLabel);
		
		txtTypeNameHere = new JTextField();
		txtTypeNameHere.setText("Type name here");
		txtTypeNameHere.setBounds(269, 134, 114, 19);
		add(txtTypeNameHere);
		txtTypeNameHere.setColumns(10);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        mBackButtonClicked.s(true);
		        if (txtTypeNameHere.getText() != null)
		        	mPlayerName.s(txtTypeNameHere.getText());
			}
		});
		btnNewButton.setBounds(423, 361, 117, 25);
		add(btnNewButton);
		fcp.revalidate();
	}

    @SuppressWarnings("empty-statement")
    public void activate() {
        fcp.show();
        //fcp.repaint();

        // w8 for click on backButton...
        while (mBackButtonClicked.g() == false)
    		;
        
        fcp.remove(this);
        fcp.repaint();
        fcp.show();
    }
}
