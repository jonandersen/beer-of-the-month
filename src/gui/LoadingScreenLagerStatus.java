package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class LoadingScreenLagerStatus extends JFrame{
	


	private JLabel jInfo;
	
	public LoadingScreenLagerStatus() {
		super("Evaluating");
		BorderLayout thisLayout = new BorderLayout();
		setLayout(thisLayout);			
		jInfo = new JLabel();
		jInfo.setText("Evaluating important beer decisions");			
		add(jInfo, BorderLayout.CENTER);			
		setLocationRelativeTo(null);			
		pack();
		setVisible(true);
	}
}
