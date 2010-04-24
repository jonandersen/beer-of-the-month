package reworked;

import gui.Settings;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;


import reworked.FridayControl.RefreshListener;
import reworked.RollControl.BotmListener;
import reworked.RollControl.ExitListener;
import reworked.RollControl.RollListener;
import reworked.RollControl.RollSettingListener;
import reworked.SettingsControl.BeerCheckBoxListener;
import reworked.SettingsControl.CancelSettingListener;
import reworked.SettingsControl.OkSettingListener;
import reworked.SettingsControl.SettingListener;


public class View extends JFrame {

	private JButton rollButton;
	private JButton settingsButton;
	private JButton exitButton;
	private JButton botmButton;
	private JButton updateButton;
	private JButton refreshFridayButton;
	private JTextArea summaryTextArea;
	private JTextArea recentHistoryTextArea;
	private JTextField fridayStatusArea;
	private JProgressBar progressBar;
	private JTextField statusInfoArea;
	private JPanel settingsPanel;
	private JButton okSettings;
	private JButton cancelSettings;
	private Font heading;
	private JCheckBox beer;
	private JCheckBox wine;
	private JCheckBox beverage;
	private JCheckBox checkStock;

	public View() {
		super("view");
		heading = new java.awt.Font("Malgun Gothic", 1, 17);
		// Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager
					.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.setLayout(new BorderLayout());

		// InfoPanel
		JPanel infoPanel = new JPanel(new GridLayout(2, 1));
		infoPanel.setPreferredSize(new Dimension(600, 400));

		// SummaryPanel
		JPanel summaryPanel = new JPanel(new BorderLayout());
		// SummaryLabel
		JLabel summary = new JLabel("Summary");
		summary.setFont(heading);
		summaryPanel.add(summary, BorderLayout.NORTH);
		// SummaryTextArea
		summaryTextArea = new JTextArea();
		summaryTextArea.setText("");
		summaryPanel.add(summaryTextArea, BorderLayout.CENTER);
		// Adding SummaryPanel to InfoPane
		infoPanel.add(summaryPanel);

		// RecentHistoryPanel
		JPanel recentHistoryPanel = new JPanel(new BorderLayout());
		// RecentHistoryLabel
		JLabel recentHistory = new JLabel("Recent history");
		recentHistory.setFont(heading);
		recentHistoryPanel.add(recentHistory, BorderLayout.NORTH);
		// SummaryTextArea
		recentHistoryTextArea = new JTextArea();
		recentHistoryTextArea.setText("");
		recentHistoryPanel.add(recentHistoryTextArea, BorderLayout.CENTER);
		// Adding RecentHistoryPanel to InfoPanel
		infoPanel.add(recentHistoryPanel);

		// Adding info panel to the frame
		add(infoPanel, BorderLayout.CENTER);

		// TopPanel
		JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 0, 0));

		// ButtonPanel
		JPanel buttonBar = new JPanel(new FlowLayout(FlowLayout.LEADING, 0, 0));

		// RollButton
		ImageIcon icon = new ImageIcon("Images/roll.png");
		rollButton = new JButton("Roll");
		rollButton.setIcon(icon);
		setButtonConstraint(rollButton);
		buttonBar.add(rollButton);

		// SettingsButton
		icon = new ImageIcon("Images/settings.png");
		settingsButton = new JButton("Settings");
		settingsButton.setIcon(icon);
		setButtonConstraint(settingsButton);
		buttonBar.add(settingsButton);

		// BeerOfMonthButton
		icon = new ImageIcon("Images/botm.png");
		botmButton = new JButton("Botm");
		botmButton.setIcon(icon);
		setButtonConstraint(botmButton);
		buttonBar.add(botmButton);

		// RefreshButton
		icon = new ImageIcon("Images/update.png");
		updateButton = new JButton("Update");
		updateButton.setIcon(icon);
		setButtonConstraint(updateButton);
		buttonBar.add(updateButton);

		// ExitButton
		icon = new ImageIcon("Images/exit.png");
		exitButton = new JButton("Exit");
		exitButton.setIcon(icon);
		setButtonConstraint(exitButton);
		buttonBar.add(exitButton);

		// Adding ButtonPanel to the TopPanel
		topPanel.add(buttonBar);

		// Erdetfredag.dk panel
		JPanel isFriday = new JPanel(new BorderLayout());

		// IsItFriday? label
		JLabel isItFriday = new JLabel("Er det fredag?");
		isFriday.add(isItFriday, BorderLayout.NORTH);

		// FridayStatus area
		fridayStatusArea = new JTextField();
		fridayStatusArea.setEditable(false);
		isFriday.add(fridayStatusArea, BorderLayout.CENTER);

		// FridayButton
		refreshFridayButton = new JButton("Refresh");
		setButtonConstraint(refreshFridayButton);
		isFriday.add(refreshFridayButton, BorderLayout.SOUTH);

		// Adding Erdetfredag.dk panel to the TopPanel
		topPanel.add(isFriday);

		// Adding TopPanel to frame
		add(topPanel, BorderLayout.NORTH);

		// StatusPanel
		JPanel statusPanel = new JPanel(new BorderLayout());
		// StatusPanelLabel
		JLabel statusLabel = new JLabel("Status");
		statusPanel.add(statusLabel, BorderLayout.WEST);
		// StatusInfoArea
		statusInfoArea = new JTextField();
		statusInfoArea.setEditable(false);
		statusPanel.add(statusInfoArea, BorderLayout.CENTER);
		// ProgressBar
		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		statusPanel.add(progressBar, BorderLayout.SOUTH);
		// Adding StatusPanel to the frame
		add(statusPanel, BorderLayout.SOUTH);
		
		
		//Settingspanel
		settingsPanel = new JPanel(new BorderLayout());
		JTabbedPane settingsTab = new JTabbedPane();
		settingsPanel.setVisible(false);
		//Checkboxes		
		beer = new JCheckBox();
		wine = new JCheckBox();
		beverage = new JCheckBox();
		checkStock = new JCheckBox();
		//Rolling tab
		JPanel rollTab = new JPanel(new BorderLayout());
		JPanel boxPanel = new JPanel(new GridLayout(4,1));
		//Checkboxes
		boxPanel.add(beer);
		boxPanel.add(wine);
		boxPanel.add(beverage);
		boxPanel.add(checkStock);
		JPanel boxLabelPanel = new JPanel(new GridLayout(4,1));
		//Checkboxes Labels
		boxLabelPanel.add(new JLabel("Beer "));
		boxLabelPanel.add(new JLabel("Wine "));
		boxLabelPanel.add(new JLabel("Beverage "));
		boxLabelPanel.add(new JLabel("Check stock "));
		rollTab.add(boxLabelPanel, BorderLayout.WEST);
		rollTab.add(boxPanel , BorderLayout.CENTER);
		//Adding roll to settingsTab
		settingsTab.addTab("Roll", rollTab);
		
		
		
		//Filter tab
		JPanel filterPanel = new JPanel(new BorderLayout());
		//FilterTextFields
		JPanel filterTextPanel = new JPanel(new GridLayout(4,3));
		JTextField price = new JTextField(3);		
		filterTextPanel.add(price);
		filterTextPanel.add(new JLabel());
		filterTextPanel.add(new JLabel());
		
		JTextField volumeMin = new JTextField(3);
		filterTextPanel.add(volumeMin);
		filterTextPanel.add(new JLabel("<=x<="));
		JTextField volumeMax = new JTextField(3);
		filterTextPanel.add(volumeMax);
		
		JTextField alchoMin = new JTextField(3);		
		filterTextPanel.add(alchoMin);
		filterTextPanel.add(new JLabel("<=x<="));
		JTextField alchoMax = new JTextField(3);		
		filterTextPanel.add(alchoMax);
		filterPanel.add(filterTextPanel, BorderLayout.EAST);
		
		//FilterLabelFields
		JPanel filterLabelPanel = new JPanel(new GridLayout(4,1));
		filterLabelPanel.add(new JLabel("Price "));
		filterLabelPanel.add(new JLabel("Volume "));
		filterLabelPanel.add(new JLabel("Alchol "));
		filterPanel.add(filterLabelPanel, BorderLayout.WEST);
		
		
		
		//Adding filter to settingsTab
		settingsTab.addTab("Filter", filterPanel);
		
		//Adding tabpanel to SettingsPanel
		settingsPanel.add(settingsTab, BorderLayout.NORTH);
		
		//ButtonBarSettings
		JPanel buttonBarSettings = new JPanel();
		okSettings = new JButton("Ok");
		cancelSettings = new JButton("Cancel");
		buttonBarSettings.add(okSettings);
		buttonBarSettings.add(cancelSettings);
		settingsPanel.add(buttonBarSettings, BorderLayout.CENTER);
		
	
		// Adding Settingspanel to the frame
		add(settingsPanel, BorderLayout.EAST);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setLocationRelativeTo(getOwner());
	}

	public void setTotal(String total) {
		summaryTextArea.setText(total);
		recentHistoryTextArea.setText("Made a roll" + "\n"
				+ recentHistoryTextArea.getText());
		progressBar.setStringPainted(false);
		progressBar.setIndeterminate(true);
	}

	public void setFriday(String answer) {
		fridayStatusArea.setText(answer);	
		statusInfoArea.setText("Updated");
		progressBar.setStringPainted(true);
		progressBar.setIndeterminate(false);
	}
	
	public void setRecentHistory(String history){
		recentHistoryTextArea.setText(history + "\n"
				+ recentHistoryTextArea.getText());
	}
	public void setShowSetting(boolean show){		
		settingsPanel.setVisible(show);
	}
	
	public void setStatus(String status) {
		statusInfoArea.setText(status);
	}

	public void addRollListener(RollListener rollListener) {
		rollButton.addActionListener(rollListener);
	}
	
	public boolean settingsIsVisible(){
		return settingsPanel.isVisible();
	}

	public void addExitListener(ExitListener exitListener) {
		exitButton.addActionListener(exitListener);
	}

	public void addBotmListener(BotmListener botmListener) {
		botmButton.addActionListener(botmListener);
	}

	public void addSettingListener(SettingListener settingListener) {
		settingsButton.addActionListener(settingListener);
	}

	public void addRefreshListener(RefreshListener refreshListener) {
		refreshFridayButton.addActionListener(refreshListener);
	}
	
	public void addCancelSettingListener(CancelSettingListener cancelSettingListener) {
		cancelSettings.addActionListener(cancelSettingListener);		
	}
	public void addOkSettingListener(OkSettingListener okSettingListener) {
		okSettings.addActionListener(okSettingListener);		
	}	
	
	public void addRollSettingListener(RollSettingListener rollSettingListener) {

	}
	
	public void addBeerCheckBoxListener(BeerCheckBoxListener beerCheckBoxListener){
		beer.addActionListener(beerCheckBoxListener);
	}

	private void setButtonConstraint(JButton button) {
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setHorizontalTextPosition(SwingConstants.CENTER);
	}

	public void setBeerCheckBox(boolean b) {
		beer.setSelected(b);
	}

	public void setWineCheckBox(boolean b) {
		wine.setSelected(b);
		
	}

	public void setBeverageCheckBox(boolean b) {
		beverage.setSelected(b);
		
	}

	

	

}
