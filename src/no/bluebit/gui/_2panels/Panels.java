package no.bluebit.gui._2panels;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panels extends JFrame {
	
	//Elements used in the application on comman hierarki
	public JButton btn1, btn2;
	private JLabel lblOutput;
	
	public Panels() {
		super("More Panels");
		
		//Fills the frame with objects of panels
		add(BorderLayout.CENTER, new TextArea());
		add(BorderLayout.EAST, new MenuPanel());
		
		//window configuration
		setSize(300,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	//Sets up the panel for the text field
	@SuppressWarnings("serial")
	private class TextArea extends JPanel {
		
		public TextArea() {
			setLayout(new GridLayout(1,1));
			
			lblOutput = new JLabel("", JLabel.CENTER);
			add(lblOutput);
		}
	}
	
	//Sets up the panel for the buttons
	@SuppressWarnings("serial")
	private class MenuPanel extends JPanel {
		
		public MenuPanel() {
			setLayout(new GridLayout(2, 1));
			
			btn1 = new JButton("Hello");
			btn2 = new JButton("world");
			
			//Create an object of the actionlistener
			EventHandler event = new EventHandler();
			
			//add the actionlistener to the buttons
			btn1.addActionListener(event);
			btn2.addActionListener(event);
			
			add(btn1);
			add(btn2);
		}
	}
	
	//Action listening for the buttons
	private class EventHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			/*
			 * Two common ways to get the object.
			 * 1: With the memmory adress of the object
			 * 2: With the text on the button
			 */
		
		/*
			//1: check the source of the button clicked
			JButton btn = (JButton) e.getSource();
			
			if(btn == btn1) {
				lblOutput.setText(btn1.getText());
			}
			if(btn == btn2) {
				lblOutput.setText(btn2.getText());
			}
		*/
			//2: check the text on the button clicked
			String txtBtnText = e.getActionCommand();
			
			if(txtBtnText.equals("Hello")) {
				lblOutput.setText(btn1.getText());
			}
			if(txtBtnText.equals("World")) {
				lblOutput.setText(btn2.getText());
			}
			
			/*
			 * I would recoment using the secound option, this makes
			 * code which is easy to read. During the next examples Im using it.
			 */
		}
		
	}
	
	//Starts the application
	public static void main(String[] args) {
		new Panels();
	}
}
