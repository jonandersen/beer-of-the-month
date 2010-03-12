package gui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JTextField alcoTextField2;
	private JTextField volumeTextField2;
	private JTextField volumeTextField1;
	private JTextField alcoTextField1;
	private JTextField priceTextField;
	private JCheckBox jMBFB;
	private JLabel jLabel1;
	private JCheckBox jLager;
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
		if(set.checkStock()){
			jLager.setSelected(true);
		}
		if(set.bFB()){
			jMBFB.setSelected(true);
		}
		
		
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setPreferredSize(new java.awt.Dimension(320, 350));
			{
				jPanel1 = new JPanel();
				jPanel1.setLayout(null);
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				jPanel1.setPreferredSize(new java.awt.Dimension(340, 300));
				{
					jBeer = new JCheckBox();
					BoxLayout jBeerLayout = new BoxLayout(jBeer, javax.swing.BoxLayout.X_AXIS);
					jBeer.setLayout(null);
					jPanel1.add(jBeer, "North");
					jBeer.setText("Beer");
					jBeer.setBounds(6, 33, 127, 23);
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
					jWine.setBounds(6, 59, 127, 23);
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
					jBeverage.setBounds(6, 85, 127, 20);
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
					jOk.setBounds(10, 270, 51, 23);
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
					jCancel.setBounds(67, 270, 77, 23);
					jCancel.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jCancelActionPerformed(evt);
						}
					});
				}
				{
					jLager = new JCheckBox();
					jPanel1.add(jLager);
					jLager.setText("Check if in stock");
					jLager.setBounds(135, 34, 143, 20);
					jLager.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jLagerMouseClicked(evt);
						}
					});
				}
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("Type:");
					jLabel1.setBounds(10, 11, 94, 15);
					jLabel1.setFont(new java.awt.Font("AlArabiya",0,16));
				}
				{
					jMBFB = new JCheckBox();
					jPanel1.add(jMBFB);
					jMBFB.setText("Most Bang for the Buck");
					jMBFB.setBounds(6, 108, 137, 23);
					jMBFB.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jMBFBMouseClicked(evt);
						}
					});
				}
				{
					priceTextField = new JTextField();
					jPanel1.add(getPriceTextField());
					priceTextField.setText(set.getPriceLessOrEqualsThen()+"");
					priceTextField.setBounds(10, 157, 73, 20);
				}
				{
					jLabel2 = new JLabel();
					jPanel1.add(jLabel2);
					jLabel2.setText("Set a price filter for less or equal ");
					jLabel2.setBounds(97, 151, 196, 21);
				}
				{
					jLabel3 = new JLabel();
					jPanel1.add(jLabel3);
					jLabel3.setText("to this price, set zero to disable filter");
					jLabel3.setBounds(97, 166, 196, 14);
				}
				{
					alcoTextField1 = new JTextField();
					jPanel1.add(getAlcoTextField1());
					alcoTextField1.setText(set.getAlco()[0]+"");
					alcoTextField1.setBounds(10, 219, 29, 20);
				}
				{
					volumeTextField1 = new JTextField();
					jPanel1.add(volumeTextField1);
					volumeTextField1.setText(set.getVolume()[0]+"");
					volumeTextField1.setBounds(10, 188, 29, 20);
				}
				{
					jLabel4 = new JLabel();
					jPanel1.add(jLabel4);
					jLabel4.setText("Set a volume filter");
					jLabel4.setBounds(128, 190, 179, 17);
				}
				{
					jLabel5 = new JLabel();
					jPanel1.add(jLabel5);
					jLabel5.setText("Set a alco filter");
					jLabel5.setBounds(128, 221, 166, 17);
				}
				{
					volumeTextField2 = new JTextField();
					jPanel1.add(volumeTextField2);
					volumeTextField2.setText(set.getVolume()[1]+"");
					volumeTextField2.setBounds(77, 188, 34, 20);
				}
				{
					alcoTextField2 = new JTextField();
					jPanel1.add(alcoTextField2);
					alcoTextField2.setText(set.getAlco()[1]+"");
					alcoTextField2.setBounds(77, 219, 34, 20);
				}
				{
					jLabel6 = new JLabel();
					jPanel1.add(jLabel6);
					jLabel6.setText("<=x<=");
					jLabel6.setBounds(38, 191, 43, 14);
				}
				{
					jLabel7 = new JLabel();
					jPanel1.add(jLabel7);
					jLabel7.setText("<=x<=");
					jLabel7.setBounds(39, 222, 43, 14);
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
		boolean exception = true;
		int price = 0;
		int[] volume = new int[2];
		int[] alco = new int[2];
		try{
			price = Integer.parseInt(priceTextField.getText().trim());
			volume[0] = Integer.parseInt(volumeTextField1.getText().trim());
			volume[1] = Integer.parseInt(volumeTextField2.getText().trim());
			alco[0] = Integer.parseInt(alcoTextField1.getText().trim());
			alco[1] = Integer.parseInt(alcoTextField2.getText().trim());
		}catch(NumberFormatException e){
			exception = false;
		}
		
		if(exception){
			set.setPriceLessOrEqualsThen(price);
			set.setVolume(volume);
			set.setAlco(alco);
			this.dispose();
		}
	
	}
	
	private void jLagerMouseClicked(MouseEvent evt) {
		jLager.setSelected(!tempSet.checkStock());
		tempSet.checkStock(!tempSet.checkStock());
	}
	
	private void jMBFBMouseClicked(MouseEvent evt) {
		jMBFB.setSelected(!tempSet.bFB());
		tempSet.setBFB(!tempSet.bFB());
	}
	
	public JTextField getPriceTextField() {
		return priceTextField;
	}
	
	public JTextField getAlcoTextField1() {
		return alcoTextField1;
	}

}
