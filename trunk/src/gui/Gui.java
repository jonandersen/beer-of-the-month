package gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import model.BeerFunctionality;
import model.Beverage;
/*
 * Created by JFormDesigner on Sat Feb 06 15:54:42 CET 2010
 */



/**
 * @author Jon Andersen
 */
public class Gui extends JFrame {
	private BeerFunctionality bf;
	private Settings set;

	public Gui(BeerFunctionality bf) {
		initComponents();
		this.setVisible(true);
		set = new Settings();
		this.bf = bf;	
	}

	private void okButtonActionPerformed(ActionEvent e) {	
		textPane1.setText("");
		if(set.rollBeer()){
			Beverage beer = bf.BeerOfTheMonth();			
			textPane1.setText(textPane1.getText() + "Beer of the Month: "+ beer.toString() + "\n");
		}
		if(set.rollWine()){
			Beverage wine = bf.WineOfTheMonth();			
			textPane1.setText(textPane1.getText() + "Wine of the Month: " + wine.toString() + "\n");
		}
		if(set.rollBeverage()){
			Beverage beverage = bf.BeverageOfTheMonth();			
			textPane1.setText(textPane1.getText() + "Beverage of the Month: " + beverage.toString() + "\n");
		}
	}

	private void configureActionPerformed(ActionEvent e) {
		Configure config = new Configure(set);		
	}

	private void cancelButtonActionPerformed(ActionEvent e) {
		System.exit(1);
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Jon Andersen
		menuBar1 = new JMenuBar();
		menu1 = new JMenu();
		menuItem1 = new JMenuItem();
		dialogPane = new JPanel();
		contentPanel = new JPanel();
		scrollPane1 = new JScrollPane();
		textPane1 = new JTextPane();
		buttonBar = new JPanel();
		okButton = new JButton();
		cancelButton = new JButton();

		//======== this ========
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//======== menuBar1 ========
		{

			//======== menu1 ========
			{
				menu1.setText("Settings");

				//---- menuItem1 ----
				menuItem1.setText("Configure");
				menuItem1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						configureActionPerformed(e);
					}
				});
				menu1.add(menuItem1);
			}
			menuBar1.add(menu1);
		}
		setJMenuBar(menuBar1);

		//======== dialogPane ========
		{
			dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));

			// JFormDesigner evaluation mark
			dialogPane.setBorder(new javax.swing.border.CompoundBorder(
				new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
					"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
					javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
					java.awt.Color.red), dialogPane.getBorder())); dialogPane.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

			dialogPane.setLayout(new BorderLayout());

			//======== contentPanel ========
			{

				//======== scrollPane1 ========
				{

					//---- textPane1 ----
					textPane1.setEditable(false);
					scrollPane1.setViewportView(textPane1);
				}

				GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
				contentPanel.setLayout(contentPanelLayout);
				contentPanelLayout.setHorizontalGroup(
					contentPanelLayout.createParallelGroup()
						.addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
							.addContainerGap())
				);
				contentPanelLayout.setVerticalGroup(
					contentPanelLayout.createParallelGroup()
						.addGroup(contentPanelLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
							.addContainerGap())
				);
			}
			dialogPane.add(contentPanel, BorderLayout.CENTER);

			//======== buttonBar ========
			{
				buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
				buttonBar.setLayout(new GridBagLayout());
				((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
				((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

				//---- okButton ----
				okButton.setText("Roll");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						okButtonActionPerformed(e);
					}
				});
				buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 5), 0, 0));

				//---- cancelButton ----
				cancelButton.setText("Exit");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cancelButtonActionPerformed(e);
					}
				});
				buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 0), 0, 0));
			}
			dialogPane.add(buttonBar, BorderLayout.SOUTH);
		}
		contentPane.add(dialogPane, BorderLayout.NORTH);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Jon Andersen
	private JMenuBar menuBar1;
	private JMenu menu1;
	private JMenuItem menuItem1;
	private JPanel dialogPane;
	private JPanel contentPanel;
	private JScrollPane scrollPane1;
	private JTextPane textPane1;
	private JPanel buttonBar;
	private JButton okButton;
	private JButton cancelButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}