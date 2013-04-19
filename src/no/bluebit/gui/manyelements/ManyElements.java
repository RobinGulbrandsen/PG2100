package no.bluebit.gui.manyelements;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * Project contains many buttons and how to work with it
 * in a list
 */
public class ManyElements extends JFrame {

	private JButton[] lstButtons;
	
	public ManyElements() {
		super("Many Elements");
		
		add(BorderLayout.CENTER, new Buttons());
		
		setSize(450,250);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	private class Buttons extends JPanel {
		
		public Buttons() {
			setLayout(new GridLayout(4,5));
			
			EventHandler event = new EventHandler();
			
			lstButtons = new JButton[20];
			for (int i = 0; i < lstButtons.length; i++) {
				//Create a new buttons
				JButton btn = new JButton("Click Me!");
				
				//Style buttons
				btn.setBackground(Color.BLUE);
				btn.setForeground(Color.YELLOW);
			
				//Add the button to the array to be able to fetch it
				lstButtons[i] = btn;
				
				//Add actionlistener
				btn.addActionListener(event);
				
				//add the button to the panel
				add(btn);
			}
		}
	}
	
	private class EventHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//All buttons have same name, comare on memeory
			JButton btn = (JButton) e.getSource();
			
			//search if its a button in the list
			for (int i = 0; i < lstButtons.length; i++) {
				
				if(btn == lstButtons[i]) {
					//The right button is found 
					
					if(lstButtons[i].getBackground() == Color.BLUE) {
						lstButtons[i].setBackground(Color.YELLOW);
						lstButtons[i].setForeground(Color.BLUE);
					} else {
						lstButtons[i].setBackground(Color.BLUE);
						lstButtons[i].setForeground(Color.YELLOW);
					}
					
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		new ManyElements();
	}
}
