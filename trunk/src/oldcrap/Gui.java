package oldcrap;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;


import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;
import server.Server;
import model.Beverage;
import model.Database;
import net.miginfocom.swing.MigLayout;
/*
 * Created by JFormDesigner on Sat Feb 06 15:54:42 CET 2010
 */




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
/**
 * @author Jon Andersen
 */
public class Gui extends JFrame {
	private Config config;
	private Database db;	
	private Thread thread;
	private RollControl rollControl;
	private BeerFunctionality bf;
	private Settings set;

	
	
	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public Settings getSet() {
		return set;
	}

	public JTextPane getStatusArea() {
		return statusArea;
	}
	
	public JTextField getInfoArea(){
		return InfoArea;
		
	}

	public Gui(BeerFunctionality bf, Database db) {
		this.db=db;
		set = new Settings();
		initComponents();		
		this.setVisible(true);		
		this.bf = bf;
		rollControl = new RollControl(this,bf);		
	}
	


	private void okButtonActionPerformed(ActionEvent e)  {
		if(set.all()){
			InfoArea.setText("Evaluating important beer decisions");
			okButton.setEnabled(false);
			settings.setEnabled(false);						
			rollControl.loadData();
		}else{
			InfoArea.setText("Nothing configured please check settings");
		}
	}	
	 void cancelButtonActionPerformed(ActionEvent e) {		
		System.exit(1);
	}
	 
	
	 
	 


	private void initComponents() {
		// JFormDesigner - Component initialization - MODIFY AT WILL!  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Jon Andersen
		
		
		
		dialogPane = new JPanel();
		BorderLayout dialogPaneLayout = new BorderLayout();
		dialogPane.setLayout(dialogPaneLayout);
		contentPanel = new JPanel();
		GroupLayout contentPanelLayout = new GroupLayout((JComponent)contentPanel);
		contentPanel.setLayout(contentPanelLayout);
		{
			statusArea = new JTextPane();
			statusArea.setEditable(false);
		}
		{
			jLabelSummary = new JLabel();
			jLabelSummary.setText("Summary");
			jLabelSummary.setFont(new java.awt.Font("Tahoma",1,14));
			jLabelSummary.setSize(234, 22);
		}
		{
			jLabelInfoArea = new JLabel();
			jLabelInfoArea.setText("History");
			jLabelInfoArea.setFont(new java.awt.Font("Tahoma",1,14));
			jLabelInfoArea.setSize(281, 23);
		}
		{
			summary = new JTextArea();
			summary.setFont(new java.awt.Font("Malgun Gothic",1,13));
			summary.setEditable(false);
		}
				contentPanelLayout.setVerticalGroup(contentPanelLayout.createSequentialGroup()
					.addComponent(jLabelSummary, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(summary, 0, 110, Short.MAX_VALUE)
					.addComponent(jLabelInfoArea, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addComponent(statusArea, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE));
				contentPanelLayout.setHorizontalGroup(contentPanelLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(contentPanelLayout.createParallelGroup()
					    .addGroup(GroupLayout.Alignment.LEADING, contentPanelLayout.createSequentialGroup()
					        .addComponent(jLabelSummary, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
					        .addGap(0, 386, Short.MAX_VALUE))
					    .addGroup(contentPanelLayout.createSequentialGroup()
					        .addComponent(summary, GroupLayout.PREFERRED_SIZE, 620, GroupLayout.PREFERRED_SIZE)
					        .addGap(0, 0, Short.MAX_VALUE))
					    .addGroup(GroupLayout.Alignment.LEADING, contentPanelLayout.createSequentialGroup()
					        .addComponent(jLabelInfoArea, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
					        .addGap(0, 338, Short.MAX_VALUE))
					    .addGroup(contentPanelLayout.createSequentialGroup()
					        .addComponent(statusArea, GroupLayout.PREFERRED_SIZE, 620, GroupLayout.PREFERRED_SIZE)
					        .addGap(0, 0, Short.MAX_VALUE)))
					.addContainerGap());

		//======== this ========
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
	
		{
			dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
			{
				configure = new JPanel();
				dialogPane.add(configure, BorderLayout.EAST);
				configure.setPreferredSize(new java.awt.Dimension(225, 245));
			}
			dialogPane.add(contentPanel, BorderLayout.CENTER);
			contentPanel.setPreferredSize(new java.awt.Dimension(425, 344));
			{
				buttonBar = new JPanel();
				dialogPane.add(buttonBar, BorderLayout.NORTH);
				FormLayout buttonBarLayout = new FormLayout(
						"max(p;5dlu), max(p;5dlu), max(p;5dlu), max(p;5dlu)", 
						"max(p;5dlu), max(p;5dlu), max(p;5dlu), max(p;5dlu)");
				buttonBar.setLayout(buttonBarLayout);				
				buttonBar.setPreferredSize(new java.awt.Dimension(640, 60));
				{	
					ImageIcon icon = new ImageIcon("Images/roll.png");
					okButton = new JButton("Roll", icon);
					buttonBar.add(okButton, new CellConstraints("2, 1, 1, 1, default, default"));
					okButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {					
							okButtonActionPerformed(e);						
						}
					});
				}
				{	
					ImageIcon icon = new ImageIcon("Images/exit.png");
					
					cancelButton = new JButton("Exit", icon);
					buttonBar.add(cancelButton, new CellConstraints("3, 1, 1, 1, default, default"));					
					cancelButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							cancelButtonActionPerformed(e);
						}
					});
				}
				{	
					ImageIcon icon = new ImageIcon("Images/settings.png");
					settings = new JButton("Settings", icon);
					buttonBar.add(settings, new CellConstraints("4, 1, 1, 1, default, default"));					
					settings.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							settingsActionPerformed(evt);
						}
					});
				}
			}
		}
		contentPane.add(dialogPane, BorderLayout.NORTH);
		dialogPane.setPreferredSize(new java.awt.Dimension(664, 428));
		{
			progress = new JPanel();				
			contentPane.add(progress);
			GroupLayout progressLayout = new GroupLayout((JComponent)progress);
			progress.setLayout(progressLayout);
			progress.setPreferredSize(new java.awt.Dimension(664, 58));
			{
				InfoArea = new JTextField();
				InfoArea.setFont(new java.awt.Font("Tahoma",0,28));
				InfoArea.setSize(620, 51);
				InfoArea.setEditable(false);
				InfoArea.setBorder(new LineBorder(new java.awt.Color(171,173,179), 0, false));
			}

			progressLayout.setHorizontalGroup(progressLayout.createSequentialGroup()
				.addContainerGap(16, 16)
				.addComponent(InfoArea, 0, 628, Short.MAX_VALUE)
				.addContainerGap());
			progressLayout.setVerticalGroup(progressLayout.createSequentialGroup()
				.addComponent(InfoArea, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(17, Short.MAX_VALUE));
		}
		config = new Config(set, configure);
		configure.setLayout(new BorderLayout());
		configure.add(config, BorderLayout.CENTER);
		config.setPreferredSize(new java.awt.Dimension(280, 293));
		configure.setVisible(false);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}
	

	
	private void settingsActionPerformed(ActionEvent evt) {			
		
		configure.setVisible(!configure.isVisible());
		pack();
		repaint();
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Jon Andersen
	
	private JPanel configure;
	private JButton settings;
	private JTextField InfoArea;
	public JButton getOkButton() {
		return okButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public JButton getSettings() {
		return settings;
	}
	
	public JTextArea getSummary(){
		return summary;
	}

	private JPanel progress;
	private JLabel jLabelInfoArea;
	private JLabel jLabelSummary;
	private JTextArea summary;
	private JPanel dialogPane;
	private JPanel contentPanel;
	private JTextPane statusArea;
	private JPanel buttonBar;
	private JButton okButton;
	private JButton cancelButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
