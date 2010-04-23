package reworked;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

import reworked.Control.BotmListener;
import reworked.Control.ExitListener;
import reworked.Control.RollListener;
import reworked.Control.SettingListener;

public class View extends JFrame{
	
	private JButton rollButton;
	private JButton settingsButton;
	private JButton exitButton;
	private JButton botmButton; 
	private JTextArea summaryTextArea;
	private JTextArea recentHistoryTextArea;
	private JProgressBar progressBar;
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
		recentHistoryPanel.add(recentHistoryTextArea, BorderLayout.CENTER);		
		//Adding RecentHistoryPanel to InfoPanel
		infoPanel.add(recentHistoryPanel);	
		
		//Adding info panel to the frame
		add(infoPanel, BorderLayout.CENTER);
		
			
		
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
		
		//ExitButton
		icon = new ImageIcon("Images/exit.png");		
		exitButton = new JButton("Exit");
		exitButton.setIcon(icon);
		setButtonConstraint(exitButton);
		buttonBar.add(exitButton);
		
		
		
		//Adding ButtonPanel to the frame
		add(buttonBar, BorderLayout.NORTH);
		
		//StatusPanel
		JPanel statusPanel = new JPanel(new BorderLayout());
		//StatusPanelLabel
		JLabel statusLabel = new JLabel("Status");	
		statusPanel.add(statusLabel, BorderLayout.WEST);
		//StatusInfoArea
		JTextField statusInfoArea = new JTextField();
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
	
	private void setButtonConstraint(JButton button){
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
	    button.setHorizontalTextPosition(SwingConstants.CENTER);
	}

}
