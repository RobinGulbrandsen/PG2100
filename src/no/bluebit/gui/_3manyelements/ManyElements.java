package no.bluebit.gui._3manyelements;

import javax.swing.JFrame;

public class ManyElements extends JFrame {

	public ManyElements() {
		super("Many Elements");
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	
	
	public static void main(String[] args) {
		new ManyElements();
	}
}
