package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


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
public class Config extends JPanel{
	private JPanel jPanel1;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JButton priceHelp;
	private JLabel price;
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
	private JPanel configure;

	
	
	
	public Config(Settings set, JPanel configure) {
		super();
		this.tempSet = new Settings();		
		this.set = set;
		this.configure = configure;
		initGUI();
		this.setVisible(true);		
		{
			jPanel1 = new JPanel();
			this.add(jPanel1);
			jPanel1.setLayout(null);
			jPanel1.setPreferredSize(new java.awt.Dimension(215, 237));
			{
				jBeer = new JCheckBox();
				BoxLayout jBeerLayout = new BoxLayout(jBeer, javax.swing.BoxLayout.X_AXIS);
				jBeer.setLayout(null);
				jPanel1.add(jBeer, "North");
				jBeer.setText("Beer");
				jBeer.setBounds(6, 33, 57, 23);
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
				jOk.setBounds(6, 202, 51, 23);
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
				jCancel.setBounds(62, 202, 77, 23);
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
				jLager.setBounds(74, 34, 129, 22);
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
				jLabel1.setBounds(10, 6, 94, 20);
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
				priceTextField.setBounds(6, 134, 73, 20);
				priceTextField.setToolTipText("Sets the maximum price. 0 to disable");
				priceTextField.setSize(73, 18);
			}
			{
				alcoTextField1 = new JTextField();
				jPanel1.add(getAlcoTextField1());
				alcoTextField1.setText(set.getAlco()[0]+"");
				alcoTextField1.setBounds(6, 179, 29, 18);
				alcoTextField1.setSize(30, 18);
			}
			{
				volumeTextField1 = new JTextField();
				jPanel1.add(volumeTextField1);
				volumeTextField1.setText(set.getVolume()[0]+"");
				volumeTextField1.setBounds(6, 157, 30, 18);
			}
			{
				jLabel4 = new JLabel();
				ImageIcon icon = new ImageIcon("Images/help.png");
				jLabel4.setIcon(icon);
				jLabel4.setToolTipText("Set a volume filter");
				jPanel1.add(jLabel4);					
				jLabel4.setBounds(112, 158, 85, 18);
			}
			{											
				jLabel5 = new JLabel();
				ImageIcon icon = new ImageIcon("Images/help.png");
				jLabel5.setIcon(icon);				
				jLabel5.setToolTipText("Set a alco filter");
				jPanel1.add(jLabel5);					
				jLabel5.setBounds(112, 179, 91, 18);
			}
			{
				volumeTextField2 = new JTextField();
				jPanel1.add(volumeTextField2);
				volumeTextField2.setText(set.getVolume()[1]+"");
				volumeTextField2.setBounds(74, 157, 34, 18);
				volumeTextField2.setSize(30, 18);
			}
			{
				alcoTextField2 = new JTextField();
				jPanel1.add(alcoTextField2);
				alcoTextField2.setText(set.getAlco()[1]+"");
				alcoTextField2.setBounds(75, 179, 34, 18);
				alcoTextField2.setSize(30, 18);
			}
			{
				jLabel6 = new JLabel();
				jPanel1.add(jLabel6);
				jLabel6.setText("<=x<=");
				jLabel6.setBounds(36, 158, 43, 16);
				jLabel6.setFont(new java.awt.Font("Segoe UI",0,12));
			}
			{
				jLabel7 = new JLabel();
				jPanel1.add(jLabel7);
				jLabel7.setText("<=x<=");
				jLabel7.setBounds(35, 180, 43, 17);
				jLabel7.setSize(43, 16);
			}
			{	
				ImageIcon icon = new ImageIcon("Images/help.png");
				price = new JLabel();
				jPanel1.add(price);
				price.setIcon(icon);					
				price.setToolTipText("Sets the maximum price. 0 to disable");
				price.setBounds(91, 133, 81, 18);
			}				
		}			
		setUp();
		
		
	}
	
	private void initGUI() {
		try {			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void setUp(){	
		tempSet.copySet(set);
		jBeer.setSelected(set.rollBeer());
		jWine.setSelected(set.rollWine());		
		jBeverage.setSelected(set.rollBeverage());
		jLager.setSelected(set.checkStock());
		jMBFB.setSelected(set.bFB());			
}
	
	private void jCancelActionPerformed(ActionEvent evt) {
		priceTextField.setText(set.getPriceLessOrEqualsThen()+"");
		volumeTextField1.setText(set.getVolume()[0]+"");
		volumeTextField2.setText(set.getVolume()[1]+"");
		alcoTextField1.setText(set.getAlco()[0]+"");
		alcoTextField2.setText(set.getAlco()[1]+"");
		repaint();
		configure.setVisible(false);
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
		boolean exception = false;
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
			exception = true;
		}
		
		if(!exception){
			set.setPriceLessOrEqualsThen(price);
			set.setVolume(volume);
			set.setAlco(alco);
			configure.setVisible(false);		
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
