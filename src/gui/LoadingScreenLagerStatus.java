package gui;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class LoadingScreenLagerStatus extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	private JLabel jInfo;
	
	public LoadingScreenLagerStatus() {
		super("Evaluating");
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			BorderLayout thisLayout = new BorderLayout();
			getContentPane().setLayout(thisLayout);
			this.setPreferredSize(new java.awt.Dimension(400, 100));
			jInfo = new JLabel();
			jInfo.setText("Evaluating important beer decisions");
			jInfo.setPreferredSize(new java.awt.Dimension(400, 62));
			jInfo.setFont(new java.awt.Font("Segoe UI",0,22));
			getContentPane().add(jInfo, BorderLayout.CENTER);			
			setLocationRelativeTo(null);
			setVisible(true);
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
