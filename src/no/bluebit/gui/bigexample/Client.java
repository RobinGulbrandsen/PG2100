package no.bluebit.gui.bigexample;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import no.bluebit.pojo.Person;

public class Client extends JFrame {
	
	private JTextField[] lstTextFields;
	
	private DefaultListModel<Person> lstModel;
	private ArrayList<Person> lstPeople;
	private JList lstBox;
	
	public Client() {
		super("My Application");
		
		add(BorderLayout.NORTH, new Input());
		add(BorderLayout.CENTER, new Output());
		add(BorderLayout.SOUTH, new Menu());
		
		setSize(500,300);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	private class Input extends JPanel {
		
		private String[] lstLabelNames = 
			{ "Firstname: " , "Lastname: " , "Age: " };
		
		public Input() {
			setLayout(new GridLayout(1,6));
			lstTextFields = new JTextField[lstLabelNames.length];
			lstPeople = new ArrayList<Person>();
			
			for (int i = 0; i < lstLabelNames.length; i++) {
				//add labels
				JLabel lbl = new JLabel(lstLabelNames[i]);
				add(lbl);
				
				//add inputfields and add to array to access them
				JTextField txtField = new JTextField();
				lstTextFields[i] = txtField;
				add(txtField);
			}
		}
	}
	
	private class Output extends JPanel {
		//contains a list of people
		ArrayList<Person> lstPeople;
		
		public Output() {
			setLayout(new GridLayout(1,1));
			lstPeople = new ArrayList<Person>();
			
			lstModel = new DefaultListModel<Person>();
			lstBox = new JList<Person>(lstModel);
			
			add(lstBox);
		}
	}
	
	private class Menu extends JPanel {
		//uses a list of names on the different buttons.
		//Try to add or remove an item to see what happens
		private String[] btnLabels = 
			{"New", "Show", "Update", "Delete", "Exit"};
		
		public Menu() {
			setLayout(new GridLayout(1, btnLabels.length));
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
			String btnLabel = e.getActionCommand();
		
			switch (btnLabel) {
				case "New"		:	createClicked(); 	break;
				case "Show"		:	readClicked(); 		break;
				case "Update"	:	updateClicked(); 	break;
				case "Delete"	:	deleteClicked();	break;
				case "Exit"		:	exitClicked(); 		break;
				
			}
		}
		
		//Methods for each button
		private void createClicked() {
			String inputFirstname = lstTextFields[0].getText();
			String inputLastname = 	lstTextFields[1].getText();
			String inputAge = 		lstTextFields[2].getText();
			
			if(validateName(inputFirstname, inputLastname) && validateAge(inputAge)) {
				Person p = new Person(inputFirstname, inputLastname, Integer.parseInt(inputAge));
				lstModel.addElement(p);
				lstPeople.add(p);
				
				//resetinput fields 
				for (int i = 0; i < lstTextFields.length; i++) {
					lstTextFields[i].setText("");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Input error!");
			}
		}
		
		private void readClicked() {
			int index = lstBox.getSelectedIndex();
			Person p = lstPeople.get(index);
			String output = p.getFirstname() + " " + p.getLastname() + "\nAge: " + p.getAge();
			JOptionPane.showMessageDialog(null, output);
		}
		
		private void updateClicked() {
			int index = lstBox.getSelectedIndex();
			Person p = lstPeople.get(index);
			String firstname = "", lastname = "";
			
			//Update firstname
			firstname = updateText("Update Firstname: ",p.getFirstname());
			if(firstname == null) {
				System.out.println("mo");
				return;
			}
			lastname = updateText("Update Lastname: ", p.getLastname());
			if(lastname == null) {
				return;
			}
			
			Person newPerson = new Person(firstname, lastname, p.getAge());
			lstPeople.remove(index);
			lstPeople.add(index, newPerson);
			lstModel.remove(index);
			lstModel.add(index, newPerson);
			
		}
		
		private void deleteClicked() {
			int index = lstBox.getSelectedIndex();
			Person p = lstPeople.get(index);
			String output = p.getFirstname() + " " + p.getLastname() + "\nAge: " + p.getAge() + "";
			
			int answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete:\n" + output);
			if(answer == JOptionPane.YES_OPTION) {
				lstPeople.remove(index);
				lstModel.remove(index);
			}
		}
		
		private void exitClicked() {
			//Exits the program
			System.exit(0);
		}
		
		//Helper methods
		private boolean validateName(String first, String last) {
			if(validateString(first) || validateString(last)) {
				return true;
			}
			return false;
		}
		
		private boolean validateString(String string) {
			if(string.equals("") || string == null) {
				return false;
			}
			return true;
		}
		
		private boolean validateAge(String age) {
			try {
				Integer.parseInt(age);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		
		public String updateText(String label, String text) {
			String firstname = null;
			do {
				firstname = JOptionPane.showInputDialog(null, label, text);
				
				if(firstname == null || !validateString(firstname)) {
					firstname = null;
				}
			}
			while(firstname == null);
			return firstname;
		}
	}
	
	public static void main(String[] args) {
		new Client();
	}
}
