package no.bluebit.gui.helloworld;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * First basic GUI with extra comments
 */
public class HelloWorld extends JFrame {
	
	//Creates the JFrame, this is the window that will show when the program is started
	public HelloWorld() {
		//name of the window
		super("Hello World!");
		
		//Fills the frame with objects of panels
		add(BorderLayout.CENTER, new TextField());
		
		//window configuration
		setSize(300,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//Makes the window open in the middle of the screen
		setLocationRelativeTo(null);
	}
	
	//An element you wish to add to your Frame
	private class TextField extends JPanel {
		
		public TextField() {
			//Sets the layout of the element
			setLayout(new GridLayout(1, 1));
			
			//adds a new label to element with text and alignment
			add(new JLabel("Hello World!", JLabel.CENTER));
		}
	}
	
	//Starts the application
	public static void main(String[] args) {
		new HelloWorld();
	}
}
