package gui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

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
public class Configure extends javax.swing.JFrame {
	private JPanel jPanel1;
	private JButton jCancel;
	private JButton jOk;
	private JCheckBox jBeverage;
	private JCheckBox jWine;
	private JCheckBox jBeer;
	private Settings tempSet;
	private Settings set;

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	* Auto-generated main method to display this JFrame
	*/
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				Settings set = new Settings();
//				set.setBeer(true);
//				Configure inst = new Configure(set);
//				
//				inst.setVisible(true);
//			}
//		});
//	}
	
	public Configure(Settings set) {
		super();
		this.tempSet = new Settings();
		tempSet.copySet(set);
		this.set = set;
		initGUI();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		if(set.rollBeer()){			
			jBeer.setSelected(true);
		}
		if(set.rollWine()){
			jWine.setSelected(true);
		}
		if(set.rollBeverage()){
			jBeverage.setSelected(true);
		}
		
		
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanel1 = new JPanel();
				jPanel1.setLayout(null);
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				jPanel1.setPreferredSize(new java.awt.Dimension(216, 266));
				{
					jBeer = new JCheckBox();
					BoxLayout jBeerLayout = new BoxLayout(jBeer, javax.swing.BoxLayout.X_AXIS);
					jBeer.setLayout(null);
					jPanel1.add(jBeer, "North");
					jBeer.setText("Beer");
					jBeer.setBounds(6, 7, 47, 23);
					jBeer.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jBeerMouseClicked(evt);
						}
					});
				}
				{
					jWine = new JCheckBox();
					jPanel1.add(jWine);
					BoxLayout jWineLayout = new BoxLayout(jWine, javax.swing.BoxLayout.X_AXIS);
					jWine.setLayout(null);
					jWine.setText("Wine");
					jWine.setBounds(6, 33, 49, 23);
					jWine.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jWineMouseClicked(evt);
						}
					});
				}
				{
					jBeverage = new JCheckBox();
					jPanel1.add(jBeverage);
					BoxLayout jBeverageLayout = new BoxLayout(jBeverage, javax.swing.BoxLayout.X_AXIS);
					jBeverage.setLayout(null);
					jBeverage.setText("Beverage");
					jBeverage.setBounds(6, 59, 71, 23);
					jBeverage.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jBeverageMouseClicked(evt);
						}
					});
				}
				{
					jOk = new JButton();
					jPanel1.add(jOk, "East");
					jOk.setText("Ok");
					jOk.setBounds(10, 89, 51, 23);
					jOk.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jOkActionPerformed(evt);
						}
					});
				}
				{
					jCancel = new JButton();
					jPanel1.add(jCancel, "South");
					jCancel.setText("Cancel");
					jCancel.setBounds(67, 89, 77, 23);
					jCancel.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jCancelActionPerformed(evt);
						}
					});
				}
			}
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void jCancelActionPerformed(ActionEvent evt) {
		this.dispose();
	}
	
	private void jBeerMouseClicked(MouseEvent evt) {
		jBeer.setSelected(!tempSet.rollBeer());
		tempSet.setBeer(!tempSet.rollBeer());
	}
	
	private void jWineMouseClicked(MouseEvent evt) {
		jWine.setSelected(!tempSet.rollWine());
		tempSet.setWine(!tempSet.rollWine());
	}
	
	private void jBeverageMouseClicked(MouseEvent evt) {
		jBeverage.setSelected(!tempSet.rollBeverage());
		tempSet.setBeverage(!tempSet.rollBeverage());
	}
	
	private void jOkActionPerformed(ActionEvent evt) {
		set.copySet(tempSet);
		this.dispose();
	}

}
