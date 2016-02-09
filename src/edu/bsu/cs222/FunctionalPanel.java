package edu.bsu.cs222;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

public class FunctionalPanel extends TransparentPanel {
	private static final long serialVersionUID = 4510876130265202846L;
	private JLabel speedBarDescription;
	
	public FunctionalPanel() {
		speedBarDescription = new JLabel("Planet Speed");
		speedBarDescription.setFont (speedBarDescription.getFont ().deriveFont (15.0f));
		speedBarDescription.setForeground(Color.white);
		add(speedBarDescription);
	}

	@Override
	public void paintComponent(Graphics g) {
		paintPanel(g);
	}

}
