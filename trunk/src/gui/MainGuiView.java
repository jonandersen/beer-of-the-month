package gui;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class MainGuiView {
	 private JFrame frame;
	
	public MainGuiView(){
	// Frame window
		JFrame frame = new JFrame("FrameDemo");

	    //frame.addWindowListener(new WindowAdapter() {
	     //   public void windowClosing(WindowEvent e) {System.exit(0);}
	    //});

	    //...create a blank label, set its preferred size...

		frame.setSize(500, 500);
	    frame.setVisible(true);

	}

}
