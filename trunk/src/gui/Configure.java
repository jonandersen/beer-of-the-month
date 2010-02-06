/*
 * Created by JFormDesigner on Sat Feb 06 16:55:31 CET 2010
 */

package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Jon Andersen
 */
public class Configure extends JFrame {
	private Settings tempSet;
	private Settings set;
	public Configure(Settings set) {
		initComponents();
		this.setVisible(true);
		this.set = set;
		tempSet = new Settings();	
		tempSet.copySet(set);
		if(tempSet.rollBeer()){			
			checkBox1.setSelected(true);
		}
		if(tempSet.rollWine()){
			checkBox2.setSelected(true);
		}
		if(tempSet.rollBeverage()){
			checkBox3.setSelected(true);
		}
	}
	
	private void okButtonActionPerformed(ActionEvent e) {
		set.copySet(tempSet);
		this.dispose();
	}

	private void cancelButtonActionPerformed(ActionEvent e) {
		this.dispose();
	}

	private void beerMouseClicked(MouseEvent e) {
		tempSet.setBeer(!tempSet.rollBeer());	
	}

	private void wineMouseClicked(MouseEvent e) {
		tempSet.setWine(!tempSet.rollWine());
	}

	private void beverageMouseClicked(MouseEvent e) {
		tempSet.setBeverage(!tempSet.rollBeverage());
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Jon Andersen
		dialogPane = new JPanel();
		contentPanel = new JPanel();
		checkBox1 = new JCheckBox();
		checkBox2 = new JCheckBox();
		checkBox3 = new JCheckBox();
		buttonBar = new JPanel();
		okButton = new JButton();
		cancelButton = new JButton();

		//======== this ========
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

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

				//---- checkBox1 ----
				checkBox1.setText("Beer");
				checkBox1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						beerMouseClicked(e);
					}
				});

				//---- checkBox2 ----
				checkBox2.setText("Wine");
				checkBox2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						wineMouseClicked(e);
					}
				});

				//---- checkBox3 ----
				checkBox3.setText("Beverage");
				checkBox3.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						beverageMouseClicked(e);
					}
				});

				GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
				contentPanel.setLayout(contentPanelLayout);
				contentPanelLayout.setHorizontalGroup(
					contentPanelLayout.createParallelGroup()
						.addGroup(contentPanelLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(contentPanelLayout.createParallelGroup()
								.addGroup(contentPanelLayout.createSequentialGroup()
									.addComponent(checkBox1, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
									.addContainerGap(262, Short.MAX_VALUE))
								.addGroup(contentPanelLayout.createSequentialGroup()
									.addComponent(checkBox2, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
									.addGap(262, 262, 262))
								.addGroup(contentPanelLayout.createSequentialGroup()
									.addComponent(checkBox3, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
									.addGap(262, 262, 262))))
				);
				contentPanelLayout.setVerticalGroup(
					contentPanelLayout.createParallelGroup()
						.addGroup(contentPanelLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(checkBox1)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(checkBox2)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(checkBox3)
							.addContainerGap(135, Short.MAX_VALUE))
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
				okButton.setText("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						okButtonActionPerformed(e);
					}
				});
				buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 5), 0, 0));

				//---- cancelButton ----
				cancelButton.setText("Cancel");
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
		contentPane.add(dialogPane, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Jon Andersen
	private JPanel dialogPane;
	private JPanel contentPanel;
	private JCheckBox checkBox1;
	private JCheckBox checkBox2;
	private JCheckBox checkBox3;
	private JPanel buttonBar;
	private JButton okButton;
	private JButton cancelButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
