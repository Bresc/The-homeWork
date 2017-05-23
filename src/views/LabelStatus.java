package views;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class LabelStatus extends JPanel{

	
	/**
	 * 
	 */
	private JLabel labelToName;
	private static final String START = "Brayan Espinosa";
	
	private static final long serialVersionUID = 1L;

	public LabelStatus() {
		this.labelToName = new JLabel(START);
		init();
	}

	private void init() {
		this.setBackground(Color.GRAY);
		this.add(this.labelToName);
	}
	
	public void react(String text, String color){
		this.setBackground(Color.decode(color));
		this.labelToName.setText(text);
	}
}