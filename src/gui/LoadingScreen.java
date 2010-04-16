package gui;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

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
public class LoadingScreen extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JProgressBar jProgressBar;
	private JLabel jLabel1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	
	public LoadingScreen() {
		super("Initializing Beer of the Month");
		initGUI();
		this.setPreferredSize(new Dimension(750, 100));
		pack();
		setLocationRelativeTo(null);
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jProgressBar = new JProgressBar(0,100);				
				getContentPane().add(jProgressBar, BorderLayout.CENTER);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1, BorderLayout.NORTH);
				jLabel1.setText("Please wait while the program is downloading information");
			}						
			setVisible(true);					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setValue(int n){
		if(n< 100 && n > 0){
			jProgressBar.setValue(n);
		}		
	}
	
	public int getValue(){
		return jProgressBar.getValue();
	}

}
