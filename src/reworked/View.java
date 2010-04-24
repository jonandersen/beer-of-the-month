package reworked;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

import reworked.FridayControl.UpdateListener;
import reworked.RollControl.BotmListener;
import reworked.RollControl.ExitListener;
import reworked.RollControl.RollListener;
import reworked.RollControl.SettingListener;

public class View extends JFrame{
	
	private JButton rollButton;
	private JButton settingsButton;
	private JButton exitButton;
	private JButton botmButton;
	private JButton refreshButton;
	private JButton fridayButton;
	private JTextArea summaryTextArea;
	private JTextArea recentHistoryTextArea;
	private JTextField fridayStatusArea;
	private JProgressBar progressBar;
	private JTextField statusInfoArea;
	private Font heading;
	
	
	public View(){
		super("view");
		heading = new java.awt.Font("Malgun Gothic",1,17);
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		this.setLayout(new BorderLayout());
		
		//InfoPanel
		JPanel infoPanel = new JPanel(new GridLayout(2,1));
		infoPanel.setPreferredSize(new Dimension(600, 400));
		
		//SummaryPanel
		JPanel summaryPanel = new JPanel(new BorderLayout());		
		//SummaryLabel
		JLabel summary = new JLabel("Summary");
		summary.setFont(heading);
		summaryPanel.add(summary, BorderLayout.NORTH);		
		//SummaryTextArea
		summaryTextArea = new JTextArea();
		summaryTextArea.setText("");
		summaryPanel.add(summaryTextArea, BorderLayout.CENTER);		
		//Adding SummaryPanel to InfoPane
		infoPanel.add(summaryPanel);
		
		//RecentHistoryPanel
		JPanel recentHistoryPanel = new JPanel(new BorderLayout());		
		//RecentHistoryLabel
		JLabel recentHistory = new JLabel("Recent history");
		recentHistory.setFont(heading);
		recentHistoryPanel.add(recentHistory, BorderLayout.NORTH);		
		//SummaryTextArea
		recentHistoryTextArea = new JTextArea();
		recentHistoryTextArea.setText("");
		recentHistoryPanel.add(recentHistoryTextArea, BorderLayout.CENTER);		
		//Adding RecentHistoryPanel to InfoPanel
		infoPanel.add(recentHistoryPanel);	
		
		//Adding info panel to the frame
		add(infoPanel, BorderLayout.CENTER);
		
		//TopPanel
		JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 0 , 0));
		
		//ButtonPanel
		JPanel buttonBar = new JPanel(new FlowLayout(FlowLayout.LEADING, 0 , 0));
		
		//RollButton
		ImageIcon icon = new ImageIcon("Images/roll.png");
		rollButton = new JButton("Roll");
		rollButton.setIcon(icon);
		setButtonConstraint(rollButton);
		buttonBar.add(rollButton);
		
		//SettingsButton
		icon = new ImageIcon("Images/settings.png");		
		settingsButton = new JButton("Settings");
		settingsButton.setIcon(icon);
		setButtonConstraint(settingsButton);
		buttonBar.add(settingsButton);
		
		//BeerOfMonthButton
		icon = new ImageIcon("Images/botm.png");
		botmButton = new JButton("Botm");
		botmButton.setIcon(icon);
		setButtonConstraint(botmButton);
		buttonBar.add(botmButton);
		
		//RefreshButton				
		icon = new ImageIcon("Images/refresh.png");		
		refreshButton = new JButton("Refresh");
		refreshButton.setIcon(icon);
		setButtonConstraint(refreshButton);
		buttonBar.add(refreshButton);
		
		//ExitButton
		icon = new ImageIcon("Images/exit.png");		
		exitButton = new JButton("Exit");
		exitButton.setIcon(icon);
		setButtonConstraint(exitButton);
		buttonBar.add(exitButton);
		
		
		
		//Adding ButtonPanel to the TopPanel
		topPanel.add(buttonBar);
		
		//Erdetfredag.dk panel
		JPanel isFriday = new JPanel(new BorderLayout());
		
		//IsItFriday? label
		JLabel isItFriday = new JLabel("Er det fredag?");
		isFriday.add(isItFriday, BorderLayout.NORTH);
		
		//FridayStatus area
		fridayStatusArea = new JTextField();
		fridayStatusArea.setEditable(false);
		isFriday.add(fridayStatusArea, BorderLayout.CENTER);
		
		//FridayButton
		fridayButton = new JButton("Update");
		setButtonConstraint(fridayButton);
		isFriday.add(fridayButton, BorderLayout.SOUTH);
		
		
		
		//Adding Erdetfredag.dk panel to the TopPanel
		topPanel.add(isFriday);
		
		//Adding TopPanel to frame
		add(topPanel, BorderLayout.NORTH);
		
		//StatusPanel
		JPanel statusPanel = new JPanel(new BorderLayout());
		//StatusPanelLabel
		JLabel statusLabel = new JLabel("Status");	
		statusPanel.add(statusLabel, BorderLayout.WEST);
		//StatusInfoArea
		statusInfoArea = new JTextField();
		statusInfoArea.setEditable(false);
		statusPanel.add(statusInfoArea, BorderLayout.CENTER);
		//ProgressBar
		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		statusPanel.add(progressBar, BorderLayout.SOUTH);
		//Adding StatusPanel to the frame
		add(statusPanel, BorderLayout.SOUTH);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setLocationRelativeTo(getOwner());
	}
	
	
	
	
	public void setTotal(String total) {
		summaryTextArea.setText(total);
		recentHistoryTextArea.setText("Made a roll" + "\n" + recentHistoryTextArea.getText());
		progressBar.setStringPainted(false);
		progressBar.setIndeterminate(true);
	}
	
	public void setFriday(String answer){
		fridayStatusArea.setText(answer);
		recentHistoryTextArea.setText("Checked if it was friday" + "\n" + recentHistoryTextArea.getText());
		statusInfoArea.setText("Updated");
	}
	
	public void setStatus(String status){
		statusInfoArea.setText(status);
	}
	
	
	
	
	

	public void addRollListener(RollListener rollListener) {
		rollButton.addActionListener(rollListener);
	}
		
	public void addExitListener(ExitListener exitListener){
		exitButton.addActionListener(exitListener);
	}
	
	public void addBotmListener(BotmListener botmListener){
		botmButton.addActionListener(botmListener);
	}
	
	public void addSettingListener(SettingListener settingListener){
		settingsButton.addActionListener(settingListener);
	}
	
	public void addUpdateListener(UpdateListener updateListener){
		fridayButton.addActionListener(updateListener);
	}
	
	private void setButtonConstraint(JButton button){
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
	    button.setHorizontalTextPosition(SwingConstants.CENTER);
	}

}
