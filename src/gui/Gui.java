package gui;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.*;
import javax.swing.*;
import javax.swing.border.*;
import server.Server;
import model.BeerFunctionality;
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
	private Server server;
	private Thread thread;
	private ServerSocket adr;
	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private BeerFunctionality bf;
	private Settings set;

	public Gui(BeerFunctionality bf, Database db) {
		this.db=db;
		set = new Settings();
		initComponents();		
		this.setVisible(true);		
		this.bf = bf;
		
	}
	


	private void okButtonActionPerformed(ActionEvent e)  {
		if(set.all()){
			InfoArea.setText("Evaluating important beer decisions");
			okButton.setEnabled(false);
			settings.setEnabled(false);						
			loadData();
		}else{
			InfoArea.setText("Nothing configured please check settings");
		}
	}	

	private void configureActionPerformed(ActionEvent e) {
		Configure config = new Configure(set);			
	}

	 void cancelButtonActionPerformed(ActionEvent e) {		 
		 try {
			 adr.close();
			
		 } catch (Exception e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
		System.exit(1);
	}
	 
	 private void loadData(){
		 Thread thread = new Thread(new Runnable() {
		        public void run() {    
		        	textPane1.setText("");			
					if(set.rollBeer()){			
						if(set.checkStock()){
							Beverage beer = null;
							try {
								if(set.getPriceLessOrEqualsThen() <= 0 && set.getVolume()[0] <=0 && set.getVolume()[1] <=0 && set.getAlco()[0]<=0 && set.getAlco()[1]<=0){
									beer = bf.BeerOfTheMonthInStock();
								}else{
									beer = bf.BeerOfTheMonthInStock(set.getPriceLessOrEqualsThen(),set.getVolume(), set.getAlco());
								}
							} catch (IOException e1) {					
								e1.printStackTrace();
								System.exit(0);
							}
							if(beer==null){
								textPane1.setText(textPane1.getText() + "Beer of the Month: "+ "Couldn't find one =(" + "\n");
							}else{
								textPane1.setText(textPane1.getText() + "Beer of the Month: "+ beer.toString() + " In stock:" + beer.getStockCount() + "\n");
							}
						}else{
							Beverage beer;
							if(set.getPriceLessOrEqualsThen() <= 0 && set.getVolume()[0] <=0 && set.getVolume()[1] <=0 && set.getAlco()[0]<=0 && set.getAlco()[1]<=0){
								 beer = bf.BeerOfTheMonth();
							}else{
								 beer = bf.BeerOfTheMonth(set.getPriceLessOrEqualsThen(),set.getVolume(), set.getAlco());
							}
							
							if(beer==null){
								textPane1.setText(textPane1.getText() + "Beer of the Month: "+ "Couldn't find one =(" + "\n");
							}else{
								textPane1.setText(textPane1.getText() + "Beer of the Month: "+ beer.toString() + "\n");
							}
							
						}				
					}
					if(set.rollWine()){
						if(set.checkStock()){
							Beverage wine = null;
							try {
								if(set.getPriceLessOrEqualsThen() <= 0 && set.getVolume()[0] <=0 && set.getVolume()[1] <=0 && set.getAlco()[0]<=0 && set.getAlco()[1]<=0){
									wine = bf.WineOfTheMonthInStock();
								}else{
									wine = bf.WineOfTheMonthInStock(set.getPriceLessOrEqualsThen(),set.getVolume(), set.getAlco());
								}
								 
							} catch (IOException e1) {					
								e1.printStackTrace();
								System.exit(0);
							}
							if(wine==null){
								textPane1.setText(textPane1.getText() + "Wine of the Month: " + "Couldn't find one =(" + "\n");
							}else{
								textPane1.setText(textPane1.getText() + "Wine of the Month: " + wine.toString() + " In stock:" + wine.getStockCount() + "\n");
							}
						}else{
							Beverage wine = null;
							if(set.getPriceLessOrEqualsThen() <= 0 && set.getVolume()[0] <=0 && set.getVolume()[1] <=0 && set.getAlco()[0]<=0 && set.getAlco()[1]<=0){
								wine = bf.WineOfTheMonth();
							}else{
								wine = bf.WineOfTheMonth(set.getPriceLessOrEqualsThen(),set.getVolume(), set.getAlco());
							}
							if(wine==null){
								textPane1.setText(textPane1.getText() + "Wine of the Month: " + "Couldn't find one =(" + "\n");
							}else{
								textPane1.setText(textPane1.getText() + "Wine of the Month: " + wine.toString() + "\n");
							}
								
							}
					}
					if(set.rollBeverage()){
						if(set.checkStock()){
							Beverage beverage = null;
							try {
								beverage = bf.BeverageOfTheMonthInStock();
							} catch (IOException e1) {					
								e1.printStackTrace();
								System.exit(0);
							}
							textPane1.setText(textPane1.getText() + "Beverage of the Month: " + beverage.toString() + "\n");
						}else{
							Beverage beverage = bf.BeverageOfTheMonth();
							textPane1.setText(textPane1.getText() + "Beverage of the Month: " + beverage.toString() + "\n");
						}
					}
					if(set.bFB()){
						Beverage beverage = bf.bangForTheBuck();
						textPane1.setText(textPane1.getText() + "Most Bang for the Buck: " + beverage.toString() + "\n");
					}
					
					InfoArea.setText("Done evaluating, check above for beverage");
					okButton.setEnabled(true);
					settings.setEnabled(true);	
		        }});
		    	// Keep gui responsive to user input.
		    thread.setPriority(Thread.NORM_PRIORITY);  // 5, EDT = 6
		    thread.start();			    
	 }
	 
	 


	private void initComponents() {
		// JFormDesigner - Component initialization - MODIFY AT WILL!  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Jon Andersen
		menuBar1 = new JMenuBar();
		menu1 = new JMenu();
		menu2 = new JMenu();
		menuItem1 = new JMenuItem();
		menuItem2 = new JMenuItem();
		menuItem2b = new JMenuItem();
		dialogPane = new JPanel();
		BorderLayout dialogPaneLayout = new BorderLayout();
		dialogPane.setLayout(dialogPaneLayout);
		contentPanel = new JPanel();
		GroupLayout contentPanelLayout = new GroupLayout((JComponent)contentPanel);
		contentPanel.setLayout(contentPanelLayout);
		{
			textPane1 = new JTextPane();
			textPane1.setEditable(false);
		}
				contentPanelLayout.setVerticalGroup(contentPanelLayout.createSequentialGroup()
					.addComponent(textPane1, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, Short.MAX_VALUE));
				contentPanelLayout.setHorizontalGroup(contentPanelLayout.createSequentialGroup()
					.addGap(6)
					.addComponent(textPane1, 0, 325, Short.MAX_VALUE)
					.addContainerGap(22, 22));

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
			//======== menu2 ========
			{
				menu2.setText("Server");

				//---- menuItem2a ----
				menuItem2.setText("Start server");
				menuItem2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						try {
							//TODO: hårdkodad port
							adr = new ServerSocket(49289, 5, InetAddress
							         .getLocalHost());
							server = new Server(db,adr);
							
						} catch (UnknownHostException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						thread = server; 
						thread.start(); 
					}
				});
				menu2.add(menuItem2);
				
				//---- menuItem2b ----
				menuItem2b.setText("Stop server");
				menuItem2b.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						try {
							adr.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					
					}
				});
				menu2.add(menuItem2b);
			}
			menuBar1.add(menu2);
			
			{
				jHistory = new JMenu();
				menuBar1.add(jHistory);
				jHistory.setText("History");
				{
					jItemHistory = new JMenuItem();
					jHistory.add(jItemHistory);
					jItemHistory.setText("See History");
					jItemHistory.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jItemHistoryActionPerformed(evt);
						}
					});
				}
			}
		}
		setJMenuBar(menuBar1);

		//======== dialogPane ========
		{
			dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
			{
				configure = new JPanel();
				dialogPane.add(configure, BorderLayout.EAST);
				configure.setPreferredSize(new java.awt.Dimension(287, 282));
			}
			


			//======== contentPanel ========
			{

				//======== scrollPane1 ========
				{

					//---- textPane1 ----
				}

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

			//======== buttonBar ========
			{

				//---- okButton ----

				//---- cancelButton ----
			}
		}
		contentPane.add(dialogPane, BorderLayout.NORTH);
		dialogPane.setPreferredSize(new java.awt.Dimension(664, 428));
		{
			progress = new JPanel();				
			contentPane.add(progress);
			GroupLayout progressLayout = new GroupLayout((JComponent)progress);
			progress.setLayout(progressLayout);
			progress.setPreferredSize(new java.awt.Dimension(664, 71));
			{
				InfoArea = new JTextField();
				InfoArea.setFont(new java.awt.Font("Tahoma",0,28));
				InfoArea.setSize(620, 51);
				InfoArea.setEditable(false);
				InfoArea.setBorder(new LineBorder(new java.awt.Color(171,173,179), 0, false));
			}

			progressLayout.setHorizontalGroup(progressLayout.createSequentialGroup()
				.addContainerGap(18, 18)
				.addComponent(InfoArea, 0, 589, Short.MAX_VALUE)
				.addContainerGap(57, 57));
			progressLayout.setVerticalGroup(progressLayout.createSequentialGroup()
				.addComponent(InfoArea, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(20, Short.MAX_VALUE));
		}
		config = new Config(set, configure);
		configure.add(config);
		config.setPreferredSize(new java.awt.Dimension(280, 293));
		configure.setVisible(false);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}
	
	private void jItemHistoryActionPerformed(ActionEvent evt) {
		String[] hist = {"Breznak", "Oktoberöl"};
		new History(hist);
	}
	
	private void settingsActionPerformed(ActionEvent evt) {		
		configure.setVisible(true);
		pack();
		repaint();
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Jon Andersen
	private JMenuBar menuBar1;
	private JMenu menu1;
	private JMenu menu2;
	private JMenu jHistory;
	private JPanel configure;
	private JButton settings;
	private JTextField InfoArea;
	private JPanel progress;
	private JMenuItem jItemHistory;
	private JMenuItem menuItem1;
	private JMenuItem menuItem2;
	private JMenuItem menuItem2b;
	private JPanel dialogPane;
	private JPanel contentPanel;
	private JTextPane textPane1;
	private JPanel buttonBar;
	private JButton okButton;
	private JButton cancelButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
