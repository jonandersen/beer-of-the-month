package control;

import gui.Gui;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

import javax.swing.JMenuItem;

import database.Database;


public abstract class FileMenuItem extends JMenuItem implements ActionListener {
    private static final String EXTENSION = ".data";
    protected Gui gui;
    protected int action;
    private String title;    
    protected Database db;

    protected FileMenuItem(Gui gui, String title, Database db) {
        super(title);
        this.gui = gui;       
        this.title = title;
        this.db = db;
        addActionListener(this);
    }

    public abstract void action(String fullName);

    public void actionPerformed(ActionEvent event) {
    	Database db = null;
        FileDialog dialog = new FileDialog(gui, title, action);
        dialog.setVisible(true);
        String file = dialog.getFile();
        String dir = dialog.getDirectory();
        dialog.dispose();
        if (file == null) {
            return;
        }
        if (!file.endsWith(EXTENSION)) {
            file += EXTENSION; 	
        }  
        action(dir + file);
        String name = file.substring(0, file.indexOf('.'));
        gui.rename(name);
    }
}