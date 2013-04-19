package no.bluebit.no.gui.exampleapp;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFirstApp extends JFrame {
	
	private JLabel lblOutput; 
	private JButton[] lstMenuButtons;

	public MyFirstApp() {
		super("My First Application");
		
		add(BorderLayout.CENTER, new Output());
		add(BorderLayout.EAST, new Menu());
		
		setSize(400,300);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	private class Output extends JPanel {
		
		public Output() {
			setLayout(new GridLayout(1,1));
			
			lblOutput = new JLabel("", JLabel.CENTER);
			add(lblOutput);
		}
	}
	
	private class Menu extends JPanel {
		//uses a list of names on the different buttons.
		//Try to add or remove an item to see what happens
		private String[] btnLabels = 
			{"Create", "Read", "Update", "Delete", "Exit"};
		
		public Menu() {
			setLayout(new GridLayout(btnLabels.length, 1));
			EventHandler event = new EventHandler();
			
			JButton btn;
			for (int i = 0; i < btnLabels.length; i++) {
				btn = new JButton(btnLabels[i]);
				btn.addActionListener(event);
				add(btn);
			}
		}
	}
	
	private class EventHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//Buttons have different names, using it
			String btnLabel = e.getActionCommand();
		
			//Switch case on string in Java 7
			//I could use an if-else but using switch-case with methods
			switch (btnLabel) {
				case "Create"	:	createClicked(); 	break;
				case "Read"		:	readClicked(); 		break;
				case "Update"	:	updateClicked(); 	break;
				case "Delete"	:	deleteClicked();	break;
				case "Exit"		:	exitClicked(); 		break;
				
			}
		}
		
		//Methods for each button
		private void createClicked() {
			lblOutput.setText("New element created!");
		}
		
		private void readClicked() {
			lblOutput.setText("Show Element!");
		}
		
		private void updateClicked() {
			lblOutput.setText("Updated Element!");
		}
		
		private void deleteClicked() {
			lblOutput.setText("Element deleted!");
		}
		
		private void exitClicked() {
			//Exits the program
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new MyFirstApp();
	}
}
